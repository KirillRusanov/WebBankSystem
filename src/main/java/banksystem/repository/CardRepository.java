package banksystem.repository;

import banksystem.dao.DAO;
import banksystem.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardRepository extends DAO<Card> {
    @Autowired
    public CardRepository() {
        setEntityClass(Card.class);
    }
}
