package banksystem.web.controller.security;

import banksystem.dao.model.Client;
import banksystem.service.sicurity.JwtTokenProvider;
import banksystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public ModelAndView authenticate(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity<?> authenticate(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpServletResponse response) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            Client client = clientService.getByUsername(username);
            String token = jwtTokenProvider.createToken(username, client.getRole().name());
            Cookie cookie = new Cookie(HttpHeaders.AUTHORIZATION, token);
            cookie.setMaxAge(60*60*24);
            cookie.setDomain("localhost");
            cookie.setPath("/");
            response.addCookie(cookie);
            response.getOutputStream().close();
            return ResponseEntity.ok(response);
        } catch (AuthenticationException | IOException ex) {
            return new ResponseEntity<>("Invalid email/password combination", HttpStatus.FORBIDDEN);
        }
    }
}
