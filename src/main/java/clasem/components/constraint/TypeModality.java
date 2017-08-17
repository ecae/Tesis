package clasem.components.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TypeModalityValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TypeModality {
    String message() default "Ingrese un tipo de modalidad válido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}