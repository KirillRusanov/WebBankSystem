package banksystem.dao.repository;

import banksystem.dao.DAO;
import banksystem.dao.model.security.ConfirmationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfirmationTokenRepository extends DAO<ConfirmationToken> {
    @Autowired
    public ConfirmationTokenRepository() {
        setEntityClass(ConfirmationToken.class);
    }
}
