package banksystem.service;

import banksystem.dao.model.security.ConfirmationToken;
import banksystem.dao.repository.ConfirmationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenService {

    @Autowired
    private ConfirmationTokenRepository repository;

    public void saveOrUpdate(ConfirmationToken token){
        repository.save(token);
    }

    public ConfirmationToken getByToken(String token) {
        return repository.findByToken(token);
    }
}
