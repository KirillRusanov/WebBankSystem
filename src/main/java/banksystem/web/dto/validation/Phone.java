package banksystem.web.dto.validation;

import java.lang.annotation.*;
import javax.validation.*;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)

public @interface Phone {
    String message() default "! phone number is already taken.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
