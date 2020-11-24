package banksystem.web.mapper;

import banksystem.web.dto.ClientDTO;
import banksystem.dao.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientMapper {

    // DTO

    public ClientDTO convertToDTO(Client client) {
        return initializationDTO(client);
    }

    public List<ClientDTO> convertToDTO(List<Client> clients) {
        List<ClientDTO> clientsDTO = new ArrayList<>();
        for(Client client : clients) {
                clientsDTO.add(initializationDTO(client));
        }
        return clientsDTO;
    }

    private ClientDTO initializationDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setSurname(client.getSurname());
        clientDTO.setPatronymic(client.getPatronymic());
        clientDTO.setAddress(client.getAddress());
        clientDTO.setBirthday(client.getBirthday());
        clientDTO.setPassNumber(client.getPassNumber());
        clientDTO.setPhoneNumber(client.getPhoneNumber());
        return clientDTO;
    }

    // ENTITY

    public Client convertToEntity(ClientDTO clientDTO) {
        return initializationEntity(clientDTO);
    }

    public List<Client> convertToEntity(List<ClientDTO> clientsDTO) {
        List<Client> clients = new ArrayList<>();
        for(ClientDTO client : clientsDTO) {
            clients.add(initializationEntity(client));
        }
        return clients;
    }

    private Client initializationEntity(ClientDTO clientDTO) {
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
}