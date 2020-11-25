package banksystem.web.mapper;

import banksystem.web.dto.ClientDTO;
import banksystem.dao.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper extends Mapper<ClientDTO, Client> {

    @Override
    public Client convertToEntity(ClientDTO clientDTO) {
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setSurname(clientDTO.getSurname());
        client.setPatronymic(clientDTO.getPatronymic());
        client.setAddress(clientDTO.getAddress());
        client.setBirthday(clientDTO.getBirthday());
        client.setPassNumber(clientDTO.getPassNumber());
        client.setPhoneNumber(clientDTO.getPhoneNumber());
        return client;
    }

    @Override
    public ClientDTO convertToDTO(Client Entity) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(Entity.getId());
        clientDTO.setName(Entity.getName());
        clientDTO.setSurname(Entity.getSurname());
        clientDTO.setPatronymic(Entity.getPatronymic());
        clientDTO.setAddress(Entity.getAddress());
        clientDTO.setBirthday(Entity.getBirthday());
        clientDTO.setPassNumber(Entity.getPassNumber());
        clientDTO.setPhoneNumber(Entity.getPhoneNumber());
        return clientDTO;
    }

}