package banksystem.repositories;

import banksystem.dao.DAO;
import banksystem.entity.Client;
import banksystem.utils.HibernateUtil;

import java.util.List;

public class ClientRepository {

    public ClientRepository() {
        this.DAO = new DAO(HibernateUtil.getSessionFactory());
    }

    private DAO DAO;

    public void save(Client o){
        DAO.save(o);
    }

    public Client read(Long id) {
        return DAO.read(Client.class, id);
    }

    public void update(Client o){
        DAO.update(o);
    }

    public void delete(Object o){
        DAO.delete(o);
    }

    public List<Client> getAll() {
        return DAO.getAll(Client.class);
    }

}
