package banksystem.service;

import banksystem.entity.Count;
import banksystem.repositories.CountRepository;

import java.util.List;

public class CountService {

    public CountService() {
        this.repository = new CountRepository();
    }
    private CountRepository repository;
    public void save(Count o){
        repository.save(o);
    }
    public Count read(Long id){
        return repository.read(id);
    }
    public void update(Count o){
        repository.update(o);
    }

    public void delete(Object o){
        repository.delete(o);
    }

    public List<Count> getAll() {
        return repository.getAll();
    }

}
