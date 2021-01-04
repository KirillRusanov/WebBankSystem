package banksystem.web.dto.validation;

import banksystem.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CountNumberValidator implements ConstraintValidator<CountNumber, String> {

    @Autowired
    private CountService countService;

    @Override
    public void initialize(CountNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String number, ConstraintValidatorContext constraintValidatorContext) {
        return countService.getByNumber(number) == null;
    }
}
