package banksystem.web.controller;

import banksystem.dao.model.Client;
import banksystem.dao.model.Count;
import banksystem.service.ClientService;
import banksystem.service.CountService;
import banksystem.web.dto.ClientDTO;
import banksystem.web.dto.CountDTO;
import banksystem.web.mapper.ClientMapper;
import banksystem.web.mapper.CountMapper;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/count")
public class CountController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private CountService countService;

    private ClientMapper clientMapper = Mappers.getMapper(ClientMapper.class);

    private CountMapper countMapper = Mappers.getMapper(CountMapper.class);

    private static final Logger LOG = LoggerFactory.getLogger(CountController.class);

    @GetMapping("/list")
    public ModelAndView getPersonalCounts(Authentication authentication, ModelAndView model) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            ClientDTO client = clientMapper.convertToDTO(clientService.getByUsername(userDetails.getUsername()));
            model.addObject("count", new CountDTO());
            model.addObject("client", client);
            model.setViewName("showPersonalCounts");
            return model;
    }

    @PostMapping("/create")
    public String addCount(Authentication authentication, @ModelAttribute("count") @Valid CountDTO newCount,
                           BindingResult result) {
        if (result.hasErrors()) {
            return "showPersonalCounts";
        } else {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Client client = clientService.getByUsername(userDetails.getUsername());
            newCount.setClient_id(client);
            newCount.setBalance(0);
            countService.saveOrUpdate(countMapper.convertToEntity(newCount));
            LOG.info("Client created an account - " + newCount.getNumber());
            return "redirect: /bank/api/count/list";
        }
    }

    @GetMapping(value = "/{id}/delete")
    public String deleteCountById(@PathVariable("id") Long id) {
        Count remoteCount = countService.getById(id);
        countService.delete(remoteCount);
        LOG.info("Client deleted an account - " + remoteCount.getNumber());
        return "redirect: /bank/api/count/list";
    }
}