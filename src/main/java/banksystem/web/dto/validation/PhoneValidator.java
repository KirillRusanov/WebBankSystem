package banksystem.web.dto.validation;

import banksystem.dao.model.Client;
import banksystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Autowired
    private ClientService clientService;

    @Override
    public void initialize(Phone constraintAnnotation) {
    }

    @Override
    public boolean isValid(String numberPhone, ConstraintValidatorContext constraintValidatorContext) {
        return clientService.getByPhone(numberPhone) == null;
    }
}
