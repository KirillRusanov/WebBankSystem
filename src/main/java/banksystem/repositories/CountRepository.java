package banksystem.repositories;

import banksystem.dao.DAO;
import banksystem.entity.Count;
import banksystem.utils.HibernateUtil;

import java.util.List;

public class CountRepository {

    public CountRepository() {
        this.DAO = new DAO(HibernateUtil.getSessionFactory());
    }

    private DAO DAO;

    public void save(Count o){
        DAO.save(o);
    }

    public Count read(Long id) {
        return DAO.read(Count.class, id);
    }

    public void update(Count o){
        DAO.update(o);
    }

    public void delete(Object o){
        DAO.delete(o);
    }

    public List<Count> getAll() {
        return DAO.getAll(Count.class);
    }

}
