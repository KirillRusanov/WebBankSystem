package banksystem.repository;

import banksystem.dao.DAO;
import banksystem.entity.Card;

public class CardRepository extends DAO<Card> {
    public CardRepository() {
        setEntityClass(Card.class);
    }
}
