package banksystem.service;

import banksystem.dao.model.Client;
import banksystem.dao.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements UserDetailsService {

    private final ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public void saveOrUpdate(Client o){
        repository.saveOrUpdate(o);
    }

    public Client getById(Long id){
        return repository.getById(id);
    }

    public Client getByUsername(String username) {
        for(Client client : getAll()) {
            if (client.getUsername().equals(username)) {
                 return client;
            }
        }
        return null;
    }

    public Client getByPhone(String phone) {
        for(Client client : getAll()) {
            if(client.getPhoneNumber().equals(phone)) {
                return client;
            }
        }
        return null;
    }

    public Client getByPassport(String passport) {
        for(Client client : getAll()) {
            if(client.getPassNumber().equals(passport))
                return client;
        }
        return null;
    }

    public void delete(Object o){
        repository.delete(o);
    }

    public List<Client> getAll() {
        return repository.getAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Client.getUserDetails(getByUsername(username));
    }

}
