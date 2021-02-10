package banksystem.dao.repository;

import banksystem.dao.model.Transfer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends CrudRepository<Transfer, Long> {

    Transfer getById(Long id);

    List<Transfer> getAllByFromCard(String fromCard);
}
