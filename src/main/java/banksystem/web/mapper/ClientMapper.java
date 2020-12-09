package banksystem.web.mapper;

import banksystem.web.dto.ClientDTO;
import banksystem.dao.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDTO convertToDTO(Client Entity);

    Client convertToEntity(ClientDTO DTO);

    List<ClientDTO> convertToDTO(List<Client> Entity);
}