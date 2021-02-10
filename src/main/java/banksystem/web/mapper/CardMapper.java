package banksystem.web.mapper;

import banksystem.dao.model.Card;
import banksystem.web.dto.CardDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CardMapper{

    CardDTO convertToDTO(Card Entity);

    Card convertToEntity(CardDTO DTO);

    List<CardDTO> convertToDTO(List<Card> Entity);

}
