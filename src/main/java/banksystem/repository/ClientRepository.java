package banksystem.repository;

import banksystem.dao.DAO;
import banksystem.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientRepository extends DAO<Client> {
    @Autowired
    public ClientRepository() {
        super(Client.class);
    }
}
