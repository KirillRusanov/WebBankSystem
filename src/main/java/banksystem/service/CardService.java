package banksystem.service;

import banksystem.entity.Card;
import banksystem.repository.CardRepository;

import java.util.List;

public class CardService {

    public CardService() {
        this.repository = new CardRepository();
    }
    private CardRepository repository;

    public void create(Card o){
        repository.create(o);
    }

    public Card getById(Long id){
        return (Card) repository.getById(id);
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
