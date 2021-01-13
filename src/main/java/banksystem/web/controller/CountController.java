package banksystem.web.controller;

import banksystem.dao.model.Client;
import banksystem.dao.model.Count;
import banksystem.service.ClientService;
import banksystem.service.CountService;
import banksystem.service.sicurity.JwtTokenProvider;
import banksystem.web.dto.CardDTO;
import banksystem.web.dto.ClientDTO;
import banksystem.web.dto.CountDTO;
import banksystem.web.mapper.ClientMapper;
import banksystem.web.mapper.CountMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/api/count")
public class CountController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private ClientService clientService;
    @Autowired
    private CountService countService;

    private ClientMapper clientMapper = Mappers.getMapper(ClientMapper.class);

    private CountMapper countMapper = Mappers.getMapper(CountMapper.class);

    @GetMapping("/list")
    public ModelAndView getPersonalCounts(HttpServletRequest request, ModelAndView model) {
        Cookie[] cookies = request.getCookies();
        String username = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("Authorization")) {
                    username = jwtTokenProvider.getUsername(cookie.getValue());
                }
            }
        }
        ClientDTO client = clientMapper.convertToDTO(clientService.getByUsername(username));
        model.addObject("countList", client.getCounts());
        model.setViewName("showPersonalCounts");
        model.addObject("count", new CountDTO());
        return model;
    }

    @PostMapping("/create")
    public String addCount(@ModelAttribute("count") @Valid CountDTO newCount,
                           BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "showPersonalCounts";
        } else {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("Authorization")) {
                        Client client = clientService.getByUsername(
                                jwtTokenProvider.getUsername(cookie.getValue()));
                        newCount.setClient_id(client);
                    }
                }
            }
            newCount.setBalance(0);
            countService.saveOrUpdate(countMapper.convertToEntity(newCount));
            return "redirect: /bank/api/count/list";
        }
    }

    @GetMapping(value = "/{id}")
    public ModelAndView getCountById(@PathVariable("id") Long id, ModelAndView model) {
        CountDTO count = countMapper.convertToDTO(countService.getById(id));
        model.addObject("cardList", count.getCards());
        model.addObject("card", new CardDTO());
        model.setViewName("showPersonalCards");
        return model;
    }

    @GetMapping(value = "/{id}/delete")
    public String deleteCountById(@PathVariable("id") Long id) {
        Count remoteCount = countService.getById(id);
        countService.delete(remoteCount);
        return "redirect: /bank/api/count/list";
    }
}