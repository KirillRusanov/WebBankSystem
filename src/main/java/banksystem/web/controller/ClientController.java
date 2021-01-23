package banksystem.web.controller;

import banksystem.service.FileService;
import banksystem.dao.model.Client;
import banksystem.service.ClientService;
import banksystem.web.dto.ClientDTO;
import banksystem.web.mapper.ClientMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private FileService fileService;

    private ClientMapper clientMapper = Mappers.getMapper(ClientMapper.class);

    @GetMapping(value = "/list")
    public ModelAndView getClientList(ModelAndView model) {
        List clients = clientService.getAll();
        model.addObject("clientList", clients);
        model.setViewName("clients");
        return model;
    }

    @GetMapping(value = "/profile/{id}")
    public ModelAndView getClientById(@PathVariable("id") Long id, ModelAndView model) {
        Client client = clientService.getById(id);
        model.addObject("client", client);
        model.setViewName("profile");
        return model;
    }

    @GetMapping(value = "/profile")
    public ModelAndView getProfile(Authentication authentication, ModelAndView model) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        ClientDTO client = clientMapper.convertToDTO(clientService.getByUsername(userDetails.getUsername()));
        model.addObject("client", client);
        model.setViewName("profile");
        return model;
    }

    @PostMapping(value = "/upload-photo", consumes = "multipart/form-data")
    public ModelAndView uploadPhoto(@RequestParam("file") MultipartFile image,
                                    Authentication authentication, ModelAndView model) throws IOException {
        if (Objects.requireNonNull(image.getContentType()).contains("image")) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Client client = clientService.getByUsername(userDetails.getUsername());
            model.addObject("client", client);
            fileService.upload(image, client);
        }
        return new ModelAndView("redirect: /bank/api/client/profile");
    }
}