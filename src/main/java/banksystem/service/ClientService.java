package banksystem.service;

import banksystem.entity.Client;
import banksystem.repositories.ClientRepository;

import java.util.List;

public class ClientService {

    public ClientService() {
        this.repository = new ClientRepository();
    }
    private ClientRepository repository;
    public void save(Client o){
        repository.save(o);
    }
    public Client read(Long id){
        return repository.read(id);
    }
    public void update(Client o){
        repository.update(o);
    }

    public void delete(Object o){
        repository.delete(o);
    }

    public List<Client> getAll() {
        return repository.getAll();
    }

}
