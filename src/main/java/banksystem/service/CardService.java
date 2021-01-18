package banksystem.service;

import banksystem.dao.model.Card;
import banksystem.dao.repository.CardRepository;
import banksystem.web.dto.CardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class CardService {

    @Autowired
    private CardService cardService;

    @Autowired
    private CountService countService;

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

    public Date getTermDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR,1);
        return calendar.getTime();
    }

    public CardDTO generateNewCard(Long countId) {
        CardDTO newCard = new CardDTO();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR,1);

        String number = "400000";
        number = number.concat(String.valueOf(new Random().nextInt(10_0000_0000 - 10_0000_000 + 1) + 10_0000_000));

        newCard.setCount(countService.getById(countId));
        newCard.setPin(String.valueOf(new Random().nextInt(10000 - 1000 + 1) + 1000));
        newCard.setTerm(calendar.getTime());
        newCard.setNumber(number);
        return newCard;
    }
}
