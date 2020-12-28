package banksystem.web.dto.validation;

import banksystem.dao.model.Client;
import banksystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PassportValidator implements ConstraintValidator<Passport, String> {

    @Autowired
    private ClientService clientService;

    @Override
    public void initialize(Passport constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        for(Client client : clientService.getAll()) {
            if (client.getPassNumber().equals(s)) return false;
        }
        return true;
    }
}
