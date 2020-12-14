package banksystem.web.mapper;

import banksystem.dao.model.Count;
import banksystem.web.dto.CountDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CountMapper {

    CountDTO convertToDTO(Count Entity);

    Count convertToEntity(CountDTO DTO);

    List<CountDTO> convertToDTO(List<Count> Entity);

}