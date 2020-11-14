package banksystem.service;

import banksystem.entity.Count;
import banksystem.repository.CountRepository;

import java.util.List;

public class CountService {

    public CountService() {
        this.repository = new CountRepository();
    }
    private CountRepository repository;

    public void create(Count o){
        repository.create(o);
    }

    public Count getById(Long id){
        return repository.getById(id);
    }

    public void update(Count o){
        repository.update(o);
    }

    public void delete(Object o){
        repository.delete(o);
    }

    public List getAll() {
        return repository.getAll();
    }

}
