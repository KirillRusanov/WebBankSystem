package banksystem.web.controller.security;

import banksystem.dao.model.Client;
import banksystem.dao.model.security.Role;
import banksystem.service.sicurity.JwtTokenProvider;
import banksystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ClientService clientService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @GetMapping("/login")
    public String authenticate() {
        return "login";
    }

    @PostMapping("/login")
    public String authenticate(@ModelAttribute Client clientForm, HttpServletResponse response) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(clientForm.getUsername(),clientForm.getPassword()));
            Client client = clientService.getByUsername(clientForm.getUsername());
            String token = jwtTokenProvider.createToken(clientForm.getUsername(), client.getRole().name());
            Cookie cookie = new Cookie(HttpHeaders.AUTHORIZATION, token);
            cookie.setMaxAge(60*60*24);
            cookie.setDomain("localhost");
            cookie.setPath("/");
            response.addCookie(cookie);
            return "redirect: /bank/api/index";
        } catch (AuthenticationException ex) {
            return "errorAuthorization";
        }
    }

    @GetMapping("/registration")
    public String register() { ;
        return "registration";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute Client client) {
        try {
            String password = new BCryptPasswordEncoder().encode(client.getPassword());
            client.setRole(Role.USER);
            client.setPassword(password);
            clientService.saveOrUpdate(client);

            return "redirect: /bank/api/auth/login";
        } catch (Exception ex) {
            return "errorRegistration";
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
