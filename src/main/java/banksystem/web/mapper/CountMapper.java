package banksystem.web.mapper;

import banksystem.dao.model.Count;
import banksystem.web.dto.CountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CountMapper {
    CountMapper INSTANCE = Mappers.getMapper(CountMapper.class);

    CountDTO convertToDTO(Count Entity);

    Count convertToEntity(CountDTO DTO);

    List<CountDTO> convertToDTO(List<Count> Entity);

}