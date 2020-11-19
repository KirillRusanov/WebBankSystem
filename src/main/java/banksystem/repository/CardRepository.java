package banksystem.repository;

import banksystem.dao.DAO;
import banksystem.model.Card;

public class CardRepository extends DAO<Card> {
    public CardRepository() {
        super(Card.class);
    }
}
