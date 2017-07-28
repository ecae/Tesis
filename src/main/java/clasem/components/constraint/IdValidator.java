package clasem.components.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdValidator implements ConstraintValidator<IdConstraint, String> {

    @Override
    public void initialize(IdConstraint idConstraint) {
    }

    @Override
    public boolean isValid(String idField, ConstraintValidatorContext context) {
        return idField != null && idField.matches("^[1-9]\\d*$");
    }
}