package banksystem.web.dto.validation;

import java.lang.annotation.*;
import javax.validation.*;

@Documented
@Constraint(validatedBy = MailValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)

public @interface Mail {
    String message() default "! this email already exists, please try another";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
