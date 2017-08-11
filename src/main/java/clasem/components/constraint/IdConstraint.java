package clasem.components.constraint;

import clasem.services.FieldValueExists;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IdValidator.class)
@Target( { ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping
public @interface IdConstraint {
    String message() default "No existe el identificador o ingrese uno válido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Class<? extends FieldValueExists> service();
    String serviceQualifier() default "";
}
