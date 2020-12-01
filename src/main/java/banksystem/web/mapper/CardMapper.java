package banksystem.web.mapper;

import banksystem.dao.model.Card;
import banksystem.web.dto.CardDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CardMapper{
    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    CardDTO convertToDTO(Card Entity);

    Card convertToEntity(CardDTO DTO);

    List<CardDTO> convertToDTO(List<Card> Entity);

}
