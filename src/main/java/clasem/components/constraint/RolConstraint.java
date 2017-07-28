package clasem.components.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RolValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RolConstraint {
    String message() default "Ingrese un ROL válido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}