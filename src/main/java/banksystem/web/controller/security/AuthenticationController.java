package banksystem.web.controller.security;

import banksystem.dao.model.Client;
import banksystem.dao.model.security.Role;
import banksystem.service.sicurity.JwtTokenProvider;
import banksystem.service.ClientService;
import banksystem.web.dto.ClientDTO;
import banksystem.web.dto.security.AuthenticationClientDTO;
import banksystem.web.mapper.ClientMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ClientService clientService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    private ClientMapper clientMapper = Mappers.getMapper(ClientMapper.class);


    @GetMapping("/login")
    public String authenticate(Model model) {
        model.addAttribute("client", new AuthenticationClientDTO());
        return "login";
    }

    @PostMapping("/login")
    public String authenticate(@ModelAttribute("client") @Valid AuthenticationClientDTO clientAuth,
                               BindingResult result,
                               HttpServletResponse response) {

        if (result.hasErrors()) {
            return "login";
        } else {
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(clientAuth.getUsername(), clientAuth.getPassword()));
                Client client = clientService.getByUsername(clientAuth.getUsername());
                String token = jwtTokenProvider.createToken(clientAuth.getUsername(), client.getRole().name());
                Cookie cookie = new Cookie(HttpHeaders.AUTHORIZATION, token);
                cookie.setMaxAge(60 * 60 * 24);
                cookie.setDomain("localhost");
                cookie.setPath("/");
                response.addCookie(cookie);
                return "redirect: /bank/api/index";
            } catch (AuthenticationException ex) {
                return "authorizationError";
            }
        }
    }


    @GetMapping("/registration")
    public String register(Model model) {
        model.addAttribute("client", new ClientDTO());
        return "registration";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute("client") @Valid ClientDTO newClient,
                           BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        } else {
            String password = new BCryptPasswordEncoder().encode(newClient.getPassword());
            newClient.setRole(Role.USER);
            newClient.setPassword(password);
            clientService.saveOrUpdate(clientMapper.convertToEntity(newClient));
            return "redirect: /bank/api/auth/login";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies) {
                cookie.setValue("");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
        return "successLogout";
    }
}
