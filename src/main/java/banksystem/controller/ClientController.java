package banksystem.controller;

import banksystem.model.Client;
import banksystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @ResponseBody
    @GetMapping(value = "list")
    public List getClientList() {
        return clientService.getAll();
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public Client getClientById(@PathVariable("id") Long id) {
        return clientService.getById(id);
    }

    @ResponseBody
    @GetMapping(value = "/{id}/delete")
    public String deleteClientById(@PathVariable("id") Long id) {
        Client remoteClient = clientService.getById(id);
        clientService.delete(remoteClient);
        return "Client deleted";
    }

    @ResponseBody
    @PostMapping(value = "/create", produces = "application/json", consumes="application/json")
    public String addClient(@RequestBody Client client) {
        clientService.create(client);
        return "Client added";
    }

    @ResponseBody
    @PostMapping(value = "/{id}/edit", produces = "application/json", consumes = "application/json")
    public String updateClient(@RequestBody Client client, @PathVariable("id") Long id) {
        Client clientUpdated = clientService.getById(id);
        clientUpdated.setPhoneNumber(client.getPhoneNumber());
        clientUpdated.setPassNumber(client.getPassNumber());
        clientUpdated.setSurname(client.getSurname());
        clientUpdated.setPatronymic(client.getPatronymic());
        clientUpdated.setBirthday(client.getBirthday());
        clientUpdated.setAddress(client.getAddress());
        clientUpdated.setName(client.getName());
        clientService.update(clientUpdated);
        return "Client updated";
    }
}
