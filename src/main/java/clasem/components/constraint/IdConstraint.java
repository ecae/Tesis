package clasem.components.constraint;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IdValidator.class)
@Target( { ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping
public @interface IdConstraint {
    String message() default "Ingrese un id válido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
