package banksystem.service;

import banksystem.entity.Card;
import banksystem.repositories.CardRepository;

import java.util.List;

public class CardService {

    public CardService() {
        this.repository = new CardRepository();
    }
    private CardRepository repository;
    public void save(Card o){
        repository.save(o);
    }
    public Card read(Long id){
        return repository.read(id);
    }
    public void update(Card o){
        repository.update(o);
    }

    public void delete(Object o){
        repository.delete(o);
    }

    public List<Card> getAll() {
        return repository.getAll();
    }

}
