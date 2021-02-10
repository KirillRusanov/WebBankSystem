package banksystem.service;

import banksystem.dao.model.Count;
import banksystem.dao.repository.CountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountService {

    @Autowired
    private CountRepository repository;

    public void saveOrUpdate(Count count){
        repository.save(count);
    }

    public void delete(Count count){
        repository.delete(count);
    }

    public Count getByNumber(String number) {
            return repository.findByNumber(number);
    }

    public Count getById(Long id){
        return repository.getById(id);
    }

    public List<Count> getAll() {
        return (List<Count>) repository.findAll();
    }
}
