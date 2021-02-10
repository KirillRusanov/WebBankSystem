package banksystem.web.dto.validation;

import banksystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MailValidator implements ConstraintValidator<Mail, String> {

    @Autowired
    private ClientService clientService;

    public void initialize(Mail constraint) {
    }

    public boolean isValid(String email, ConstraintValidatorContext context) {
        return clientService.getByEmail(email) == null;
    }
}