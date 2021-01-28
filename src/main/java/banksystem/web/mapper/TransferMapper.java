package banksystem.web.mapper;

import banksystem.dao.model.Transfer;
import banksystem.web.dto.TransferDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TransferMapper {

    Transfer convertToDTO(Transfer Entity);

    Transfer convertToEntity(TransferDTO DTO);

    List<TransferDTO> convertToDTO(List<Transfer> Entity);

}