package banksystem.dao.repository;

import banksystem.dao.model.Count;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountRepository extends CrudRepository<Count, Long> {

    Count findByNumber(String number);

    Count getById(Long id);

}
