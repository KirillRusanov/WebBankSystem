package banksystem.web.dto.validation;

import banksystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<Username, String> {

   @Autowired
   private ClientService clientService;

   public void initialize(Username constraint) {
   }

   public boolean isValid(String username, ConstraintValidatorContext context) {
      return clientService.getByUsername(username) != null;
   }
}
