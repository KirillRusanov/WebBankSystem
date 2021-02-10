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
        return repository.findByUsername(username);
    }

    public Client getByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Client getByPhone(String phone) {
        return repository.findByPhoneNumber(phone);
    }

    public Client getByPassport(String passport) {
        return repository.findByPassNumber(passport);
    }

    public List<Client> getAll() {
        return (List<Client>) repository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Client.getUserDetails(getByUsername(username));
    }
}