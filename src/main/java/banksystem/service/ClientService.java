package banksystem.service;

import banksystem.entity.Client;
import banksystem.repository.ClientRepository;

import java.util.List;

public class ClientService {

    public ClientService() {
        this.repository = new ClientRepository();
    }
    private ClientRepository repository;

    public void create(Client o){
        repository.create(o);
    }

    public Client getById(Long id){
        return repository.getById(id);
    }

    public void update(Client o){
        repository.update(o);
    }

    public void delete(Object o){
        repository.delete(o);
    }

    public List getAll() {
        return repository.getAll();
    }

}
