package banksystem.service;

import banksystem.dao.model.Card;
import banksystem.dao.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository repository;

    public void saveOrUpdate(Card card){
        repository.save(card);
    }

    public void delete(Card card){
        repository.delete(card);
    }

    public Card getById(Long id){
        return repository.getById(id);
    }

    public List<Card> getAll() {
        return (List<Card>) repository.findAll();
    }

}
