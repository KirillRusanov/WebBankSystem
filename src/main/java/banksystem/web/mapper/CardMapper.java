package banksystem.web.mapper;

import banksystem.dao.model.Card;
import banksystem.web.dto.CardDTO;
import org.springframework.stereotype.Component;

@Component
public class CardMapper extends Mapper<CardDTO, Card> {

    @Override
    public CardDTO convertToDTO(Card card) {
        CardDTO cardDTO = new CardDTO();
        cardDTO.setId(card.getId());
        cardDTO.setNumber(card.getNumber());
        cardDTO.setPin(card.getPin());
        cardDTO.setBirthday(card.getBirthday());
        return cardDTO;
    }
    @Override
    public Card convertToEntity(CardDTO cardDTO) {
        Card card = new Card();
        card.setId(cardDTO.getId());
        card.setNumber(cardDTO.getNumber());
        card.setPin(cardDTO.getPin());
        card.setBirthday(cardDTO.getBirthday());
        return card;
    }

}
