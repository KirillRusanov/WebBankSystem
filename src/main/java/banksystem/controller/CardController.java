package banksystem.controller;

import banksystem.model.Card;
import banksystem.service.CardService;
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
        return cardService.getAll();
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public Card getCardById(@PathVariable("id") Long id) {
        return cardService.getById(id);
    }

    @ResponseBody
    @GetMapping(value = "/{id}/delete")
    public String deleteCardById(@PathVariable("id") Long id) {
        Card remoteCard = cardService.getById(id);
        cardService.delete(remoteCard);
        return "Card deleted";
    }

    @ResponseBody
    @PostMapping(value = "/create", produces = "application/json", consumes="application/json")
    public String addCard(@RequestBody Card card) {
        cardService.create(card);
        return "Card added";
    }

    @ResponseBody
    @PostMapping(value = "/{id}/edit", produces = "application/json", consumes = "application/json")
    public String updateCard(@RequestBody Card card, @PathVariable("id") Long id) {
        Card cardUpdated = cardService.getById(id);
        cardUpdated.setNumber(card.getNumber());
        cardUpdated.setPin(card.getPin());
        cardService.update(cardUpdated);
        return "Client updated";
    }
}
