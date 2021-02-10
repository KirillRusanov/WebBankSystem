package banksystem.web.dto.validation;

import java.lang.annotation.*;
import javax.validation.*;

@Documented
@Constraint(validatedBy = PassportValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)

public @interface Passport {
    String message() default "! passport number is already taken.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
