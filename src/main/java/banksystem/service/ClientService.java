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

    @Autowired
    private ClientRepository repository;

    public void saveOrUpdate(Client o) {
         repository.save(o);
    }

    public void delete(Client o) {
        repository.delete(o);
    }

    public Client getById(Long id) {
        return repository.getById(id);
    }

    public Client getByUsername(String username) {
        try {
            return repository.findByUsername(username);
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public Client getByPhone(String phone) {
        try {
            return repository.findByPhoneNumber(phone);
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public Client getByPassport(String passport) {
        try {
            return repository.findByPassNumber(passport);
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public List<Client> getAll() {
        return (List<Client>) repository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Client.getUserDetails(getByUsername(username));
    }
}