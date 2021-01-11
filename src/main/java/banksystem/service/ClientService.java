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

    public Client getByEmail(String email) {
        return repository.getByEmail(email);
    }

    public Client getByPhone(String phone) {
        return repository.getByPhone(phone);
    }

    public Client getByUsername(String username) {
        return repository.getByUsername(username);
    }
    public Client getByPassport(String passport) {
        return repository.getByPassport(passport);
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
