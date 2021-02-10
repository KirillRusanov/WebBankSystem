package banksystem.web.mapper;

import banksystem.web.dto.ClientDTO;
import banksystem.dao.model.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ClientMapper {

    ClientDTO convertToDTO(Client Entity);

    Client convertToEntity(ClientDTO DTO);

    List<ClientDTO> convertToDTO(List<Client> Entity);
}