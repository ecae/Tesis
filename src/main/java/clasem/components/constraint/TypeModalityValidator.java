package clasem.components.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TypeModalityValidator implements ConstraintValidator<TypeModality, String> {

    @Override
    public void initialize(TypeModality typeModality) {
    }

    @Override
    public boolean isValid(String typeModality, ConstraintValidatorContext context) {
        return typeModality != null && typeModality.matches("^(HOROMETER|DAYS)$");
    }
}