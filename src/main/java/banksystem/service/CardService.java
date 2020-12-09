package banksystem.service;

import banksystem.dao.model.Card;
import banksystem.dao.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private CardRepository repository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.repository = cardRepository;
    }

    public void save(Card o){
        repository.save(o);
    }

    public Card getById(Long id){
        return repository.getById(id);
    }

    public void delete(Object o){
        repository.delete(o);
    }

    public List getAll() {
        return repository.getAll();
    }

}
