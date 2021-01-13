package banksystem.web.controller;

import banksystem.dao.model.Card;
import banksystem.service.CardService;
import banksystem.service.ClientService;
import banksystem.service.CountService;
import banksystem.service.sicurity.JwtTokenProvider;
import banksystem.web.dto.CardDTO;
import banksystem.web.dto.CountDTO;
import banksystem.web.mapper.CardMapper;
import banksystem.web.mapper.CountMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    private CardService cardService;
    @Autowired
    private CountService countService;

    private CountMapper countMapper = Mappers.getMapper(CountMapper.class);

    private CardMapper cardMapper = Mappers.getMapper(CardMapper.class);

    @GetMapping(value = "/list")
    public ModelAndView getCardList(@PathParam("id") Long id, ModelAndView model) {
        CountDTO count = countMapper.convertToDTO(countService.getById(id));
        model.addObject("cardList", count.getCards());
        model.addObject("card", new CardDTO());
        model.addObject("count", countMapper.convertToEntity(count));
        model.setViewName("showPersonalCards");
        return model;
    }

    @GetMapping(value = "/{id}")
    public CardDTO getCardById(@PathVariable("id") Long id) {
        return cardMapper.convertToDTO(cardService.getById(id));
    }

    @GetMapping(value = "/{id}/delete")
    public String deleteCardById(@PathVariable("id") Long id) {
        Card remoteCard = cardService.getById(id);
        cardService.delete(remoteCard);
        return "redirect: /bank/api/card/list?id=" + remoteCard.getCount().getId();
    }

    @GetMapping(value = "{count}/create")
    public String addCard(@PathVariable("count") Long countId) {
            cardService.saveOrUpdate(cardMapper.convertToEntity(cardService.generateNewCard(countId)));
            return "redirect: /bank/api/card/list?id=" + countId;
    }

    @PostMapping(value = "/edit")
    public CardDTO updateCard(@RequestBody @Valid CardDTO cardDTO) {
        cardService.saveOrUpdate(cardMapper.convertToEntity(cardDTO));
        return cardDTO;
    }
}
