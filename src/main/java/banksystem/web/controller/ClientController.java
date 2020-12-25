package banksystem.web.controller;

import banksystem.web.dto.ClientDTO;
import banksystem.dao.model.Client;
import banksystem.service.ClientService;
import banksystem.web.mapper.ClientMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    private ClientMapper clientMapper = Mappers.getMapper(ClientMapper.class);

    @GetMapping(value = "/list")
    public ModelAndView getClientList(ModelAndView model) {
        List clients = clientService.getAll();
        model.addObject("clientList", clients);
        model.setViewName("clients");
        return model;
    }

    @GetMapping(value = "/{id}")
    public ModelAndView getClientById(@PathVariable("id") Long id, ModelAndView model) {
        ClientDTO client = clientMapper.convertToDTO(clientService.getById(id));
        model.addObject("countList", client.getCounts());
        model.setViewName("showPersonalCounts");
        return model;
    }

    @ResponseBody
    @GetMapping(value = "/{id}/delete")
    public Client deleteClientById(@PathVariable("id") Long id) {
        Client remoteClient = clientService.getById(id);
        clientService.delete(remoteClient);
        return remoteClient;
    }

    @ResponseBody
    @PostMapping(value = "/create", produces = "application/json", consumes="application/json")
    public ClientDTO addClient(@RequestBody ClientDTO clientDTO) {
        clientService.saveOrUpdate(clientMapper.convertToEntity(clientDTO));
        return clientDTO;
    }

    @ResponseBody
    @PostMapping(value = "/edit", produces = "application/json", consumes = "application/json")
    public ClientDTO updateClient(@RequestBody ClientDTO clientDTO) {
        clientService.saveOrUpdate(clientMapper.convertToEntity(clientDTO));
        return clientDTO;
    }
}
