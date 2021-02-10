package banksystem.dao.repository;

import banksystem.dao.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    Client findByPhoneNumber(String phoneNumber);

    Client findByPassNumber(String passNumber);

    Client findByUsername(String username);

    Client findByEmail(String email);

    Client getById(Long id);

}
