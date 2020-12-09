package banksystem.web.controller;

import banksystem.dao.model.Card;
import banksystem.service.CardService;
import banksystem.web.dto.CardDTO;
import banksystem.web.mapper.CardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @ResponseBody
    @GetMapping(value = "list")
    public List getCardList() {
        List cards = cardService.getAll();
        return CardMapper.INSTANCE.convertToDTO(cards);
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public CardDTO getCardById(@PathVariable("id") Long id) {
        return CardMapper.INSTANCE.convertToDTO(cardService.getById(id));
    }

    @ResponseBody
    @GetMapping(value = "/{id}/delete")
    public Card deleteCardById(@PathVariable("id") Long id) {
        Card remoteCard = cardService.getById(id);
        cardService.delete(remoteCard);
        return remoteCard;
    }

    @ResponseBody
    @PostMapping(value = "/create", produces = "application/json", consumes="application/json")
    public CardDTO addCard(@RequestBody CardDTO cardDTO) {
        cardService.save(CardMapper.INSTANCE.convertToEntity(cardDTO));
        return cardDTO;
    }

    @ResponseBody
    @PostMapping(value = "/edit", produces = "application/json", consumes = "application/json")
    public CardDTO updateCard(@RequestBody CardDTO cardDTO) {
        cardService.save(CardMapper.INSTANCE.convertToEntity(cardDTO));
        return cardDTO;
    }
}
