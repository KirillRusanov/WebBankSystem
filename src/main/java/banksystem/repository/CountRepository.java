package banksystem.repository;

import banksystem.dao.DAO;
import banksystem.model.Count;

public class CountRepository extends DAO<Count> {
    public CountRepository() {
        super(Count.class);
    }
}
