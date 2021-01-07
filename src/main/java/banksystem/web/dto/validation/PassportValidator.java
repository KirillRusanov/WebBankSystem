package banksystem.web.dto.validation;

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
    public boolean isValid(String numberPassport, ConstraintValidatorContext constraintValidatorContext) {
        return clientService.getByPassport(numberPassport) == null;
    }
}
