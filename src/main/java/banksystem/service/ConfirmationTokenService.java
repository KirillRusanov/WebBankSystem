package banksystem.service;

import banksystem.dao.model.security.ConfirmationToken;
import banksystem.dao.repository.ConfirmationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository repository;

    @Autowired
    public ConfirmationTokenService(ConfirmationTokenRepository repository) {
        this.repository = repository;
    }

    public void saveOrUpdate(ConfirmationToken o){
        repository.saveOrUpdate(o);
    }

    public ConfirmationToken getByToken(String token) {
        return repository.getByToken(token);
    }
}
