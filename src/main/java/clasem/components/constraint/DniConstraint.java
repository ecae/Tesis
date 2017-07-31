package clasem.components.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DniValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DniConstraint {
    String message() default "Ingrese un número de DNI válido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}