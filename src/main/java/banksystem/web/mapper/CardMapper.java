package banksystem.web.mapper;

import banksystem.dao.model.Card;
import banksystem.web.dto.CardDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CardMapper {

    // DTO

    public CardDTO convertToDTO(Card card) {
        CardDTO cardDTO = new CardDTO();
        cardDTO.setId(card.getId());
        cardDTO.setNumber(card.getNumber());
        cardDTO.setPin(card.getPin());
        cardDTO.setBirthday(card.getBirthday());
        return cardDTO;
    }

    public List<CardDTO> convertToDTO(List<Card> cards) {
        List<CardDTO> cardsDTO = new ArrayList<>();
        for(Card card : cards) {
            cardsDTO.add(convertToDTO(card));
        }
        return cardsDTO;
    }

    // ENTITY

    public Card convertToEntity(CardDTO cardDTO) {
        Card card = new Card();
        card.setId(cardDTO.getId());
        card.setNumber(cardDTO.getNumber());
        card.setPin(cardDTO.getPin());
        card.setBirthday(cardDTO.getBirthday());
        return card;
    }

    public List<Card> convertToEntity(List<CardDTO> cardsDTO) {
        List<Card> cards = new ArrayList<>();
        for(CardDTO card : cardsDTO) {
            cards.add(convertToEntity(card));
        }
        return cards;
    }

}
