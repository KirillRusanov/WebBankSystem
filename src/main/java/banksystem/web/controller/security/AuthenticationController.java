package banksystem.web.controller.security;

import banksystem.dao.model.Client;
import banksystem.dao.model.security.ConfirmationToken;
import banksystem.dao.model.security.Role;
import banksystem.service.ConfirmationTokenService;
import banksystem.service.MailSenderService;
import banksystem.service.sicurity.JwtTokenProvider;
import banksystem.service.ClientService;
import banksystem.web.dto.ClientDTO;
import banksystem.web.dto.security.AuthenticationClientDTO;
import banksystem.web.mapper.ClientMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private MailSenderService mailSenderService;

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
    public ModelAndView register(@ModelAttribute("client") @Valid ClientDTO newClient,
                           BindingResult result, ModelAndView model) throws MessagingException {

        if (result.hasErrors()) {
            model.setViewName("registration");
            return model;

        } else {
            String password = new BCryptPasswordEncoder().encode(newClient.getPassword());
            newClient.setRole(Role.USER);
            newClient.setPassword(password);

            Client client = clientMapper.convertToEntity(newClient);
            clientService.saveOrUpdate(client);

            String token = UUID.randomUUID().toString();

            ConfirmationToken confirmationToken = new ConfirmationToken(client, token, new Date());
            confirmationTokenService.saveOrUpdate(confirmationToken);

            mailSenderService.sendVerification(token, client);

            model.addObject("email", newClient.getEmail());
            model.setViewName("registrationSuccess");
            return model;
        }
    }

    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token") String confirmationToken)
    {
        ConfirmationToken token = confirmationTokenService.getByToken(confirmationToken);

        if(token != null)
        {
            Client client = clientService.getByEmail(token.getClient().getEmail());
            client.setVerified(true);
            clientService.saveOrUpdate(client);
            modelAndView.setViewName("accountVerified");
        }
        else
        {
            modelAndView.addObject("message","The link is invalid or broken!");
            modelAndView.setViewName("verificationError");
        }

        return modelAndView;
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
