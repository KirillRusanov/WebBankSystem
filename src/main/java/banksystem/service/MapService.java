package banksystem.service;

import banksystem.dao.ClientDTO;
import banksystem.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapService {

    @Autowired
    private ClientService clientService;

    public List<ClientDTO> getAllClient() {
        return ((List<Client>) clientService.getAll()).stream()
                .map(this::convertToClientDTO)
                .collect(Collectors.toList());
    }
    public ClientDTO getClientById(Client client) {
        return convertToClientDTO(client);
    }

    private ClientDTO convertToClientDTO(Client client) {
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
}