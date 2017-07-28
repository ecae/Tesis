package clasem.components.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RolValidator implements ConstraintValidator<RolConstraint, String> {

    @Override
    public void initialize(RolConstraint rolConstraint) {
    }

    @Override
    public boolean isValid(String rolField, ConstraintValidatorContext context) {
        return rolField != null && rolField.matches("^(ROLE_ADMIN|ROLE_USER)$");
    }
}