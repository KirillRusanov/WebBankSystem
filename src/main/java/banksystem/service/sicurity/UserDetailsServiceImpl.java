package banksystem.service.sicurity;

import banksystem.dao.model.Client;
import banksystem.dao.model.security.SecurityClient;
import banksystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientService clientService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientService.getByEmail(email);
        return SecurityClient.fromClient(client);
    }
}
