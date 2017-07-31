package clasem.components.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CellPhoneValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CellPhoneConstraint {
    String message() default "Ingrese un número de celular válido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}