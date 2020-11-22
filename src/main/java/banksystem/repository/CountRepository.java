package banksystem.repository;

import banksystem.dao.DAO;
import banksystem.model.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountRepository extends DAO<Count> {
    @Autowired
    public CountRepository() {
        setEntityClass(Count.class);
    }
}
