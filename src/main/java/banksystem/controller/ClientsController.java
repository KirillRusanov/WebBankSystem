package banksystem.controller;


import banksystem.model.Client;
import banksystem.service.ClientService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@EnableWebMvc
@Controller
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "")
    @ResponseBody
    public void index(HttpServletResponse resp) throws IOException {
        List <Client> clients = clientService.getAll();
        resp.setContentType("application/json");

        for (Client client : clients)
        {
            resp.getWriter().print("{\n" +
                    "  \"id\": " + client.getId() + ",\n" +
                    "  \"name\": " + client.getName() + ",\n" +
                    "  \"surname\": "  + client.getSurname() + ",\n" +
                    "}\n");
        }
    }
    @GetMapping("/{id}")
    @ResponseBody
    public void show(@PathVariable("id") Long id, HttpServletResponse resp) throws IOException {
//        model.addAttribute("client", clientService.getById(id));
        Client client = clientService.getById(id);
        resp.setContentType("application/json");
        resp.getWriter().print("{\n" +
                "  \"id\": " + client.getId() + ",\n" +
                "  \"name\": " + client.getName() + ",\n" +
                "  \"surname\": "  + client.getSurname() + ",\n" +
                "}\n");
    }
}
