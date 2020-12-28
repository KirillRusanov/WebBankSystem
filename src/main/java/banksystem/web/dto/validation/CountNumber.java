package banksystem.web.dto.validation;

import java.lang.annotation.*;
import javax.validation.*;

@Documented
@Constraint(validatedBy = CountNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)

public @interface CountNumber {
    String message() default "! this account number already exists, please try another";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
