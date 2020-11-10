package banksystem.repositories;

import banksystem.dao.DAO;
import banksystem.entity.Card;
import banksystem.utils.HibernateUtil;

import java.util.List;

public class CardRepository {

    public CardRepository() {
        this.DAO = new DAO(HibernateUtil.getSessionFactory());
    }

    private DAO DAO;

    public void save(Card o){
        DAO.save(o);
    }

    public Card read(Long id) {
        return DAO.read(Card.class, id);
    }

    public void update(Card o){
        DAO.update(o);
    }

    public void delete(Object o){
        DAO.delete(o);
    }

    public List<Card> getAll() {
        return DAO.getAll(Card.class);
    }

}
