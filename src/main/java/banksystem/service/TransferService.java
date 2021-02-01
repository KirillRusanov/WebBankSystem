package banksystem.service;

import banksystem.dao.model.Transfer;
import banksystem.dao.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {
    
    @Autowired
    TransferRepository repository;

    public void saveOrUpdate(Transfer transfer){
        repository.save(transfer);
    }

    public void delete(Transfer transfer){
        repository.delete(transfer);
    }

    public Transfer getById(Long id){
        return repository.getById(id);
    }

    public List<Transfer> getAll() {
        return (List<Transfer>) repository.findAll();
    }

    public List<Transfer> getAllByFromCard(String fromCard) {
        return repository.getAllByFromCard(fromCard);
    }
}
