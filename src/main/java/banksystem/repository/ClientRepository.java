package banksystem.repository;

import banksystem.dao.DAO;
import banksystem.entity.Client;

public class ClientRepository extends DAO<Client> {
    public ClientRepository() {
        setEntityClass(Client.class);
    }
}
