package banksystem.service;

import banksystem.dao.model.Count;
import banksystem.dao.repository.CountRepository;
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

    public void save(Count o){
        repository.save(o);
    }

    public Count getById(Long id){
        return repository.getById(id);
    }

    public void delete(Object o){
        repository.delete(o);
    }

    public List getAll() {
        return repository.getAll();
    }

}
