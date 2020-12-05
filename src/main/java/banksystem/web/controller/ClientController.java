package banksystem.web.controller;

import banksystem.service.ParserJsonDataFromFileToPojo;
import banksystem.web.dto.ClientDTO;
import banksystem.dao.model.Client;
import banksystem.service.ClientService;
import banksystem.web.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Controller
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ParserJsonDataFromFileToPojo parserJsonDataFromFileToPojo;

    @ResponseBody
    @GetMapping(value = "list")
    public List getClientList() {
        List clients = clientService.getAll();
        return ClientMapper.INSTANCE.convertToDTO(clients);
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ClientDTO getClientById(@PathVariable("id") Long id) {
        return ClientMapper.INSTANCE.convertToDTO(clientService.getById(id));
    }

    @ResponseBody
    @GetMapping(value = "parse")
    public String parseClientFromJson() throws IOException {
        parserJsonDataFromFileToPojo.parse();
        return "Successful";
    }

    @ResponseBody
    @PostMapping(value = "upload", headers = "content-type=multipart/form-data")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return parserJsonDataFromFileToPojo.parse(file);
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
        clientService.create(ClientMapper.INSTANCE.convertToEntity(clientDTO));
        return clientDTO;
    }

    @ResponseBody
    @PostMapping(value = "/edit", produces = "application/json", consumes = "application/json")
    public ClientDTO updateClient(@RequestBody ClientDTO clientDTO) {
        clientService.update(ClientMapper.INSTANCE.convertToEntity(clientDTO));
        return clientDTO;
    }
}
