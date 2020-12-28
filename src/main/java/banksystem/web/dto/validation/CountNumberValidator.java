package banksystem.web.dto.validation;

import banksystem.dao.model.Count;
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
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        for(Count count : countService.getAll()) {
            if (count.getNumber().equals(s)) return false;
        }
        return true;
    }
}
