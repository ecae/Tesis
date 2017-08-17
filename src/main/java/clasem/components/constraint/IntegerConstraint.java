package clasem.components.constraint;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
@Documented
@Constraint(validatedBy = IntegerValidator.class)
@Target( { ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping
public @interface IntegerConstraint {
    String message() default "Ingrese un número válido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}