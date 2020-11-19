package banksystem.service;

import banksystem.model.Card;
import banksystem.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    public CardService() {
        this.repository = new CardRepository();
    }
    private CardRepository repository;

    public void create(Card o){
        repository.create(o);
    }

    public Card getById(Long id){
        return repository.getById(id);
    }

    public void update(Card o){
        repository.update(o);
    }

    public void delete(Object o){
        repository.delete(o);
    }

    public List getAll() {
        return repository.getAll();
    }

}
