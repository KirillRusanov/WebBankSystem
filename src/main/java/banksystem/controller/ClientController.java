package banksystem.controller;

import banksystem.dao.ClientDTO;
import banksystem.model.Client;
import banksystem.service.ClientService;
import banksystem.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private MapService mapService;

    @ResponseBody
    @GetMapping(value = "list")
    public List getClientList() {
        return mapService.getAllClient();
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ClientDTO getClientById(@PathVariable("id") Long id) {
        return mapService.getClientById(clientService.getById(id));
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
