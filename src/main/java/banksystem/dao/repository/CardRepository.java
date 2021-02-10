package banksystem.dao.repository;


import banksystem.dao.model.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {

    Card getById(Long id);

    Card findByNumber(String number);
}
