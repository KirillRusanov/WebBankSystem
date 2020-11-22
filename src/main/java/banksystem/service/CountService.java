package banksystem.service;

import banksystem.model.Count;
import banksystem.repository.CountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountService {

    private CountRepository repository;

    @Autowired
    public CountService(CountRepository countRepository) {
        this.repository = countRepository;
    }

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
