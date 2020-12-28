package banksystem.web.dto.validation;

import java.lang.annotation.*;
import javax.validation.*;

@Documented
@Constraint(validatedBy = UsernameValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)

public @interface Username {
    String message() default "! this username already exists, please try another";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
