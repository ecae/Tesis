package clasem.components.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IntegerValidator implements ConstraintValidator<IntegerConstraint, String> {

    @Override
    public void initialize(IntegerConstraint integerConstraint) {
    }

    @Override
    public boolean isValid(String number, ConstraintValidatorContext context) {
        if(number == null) {
            return true;
        }
        return ( number.matches("^[0-9]\\d*$"));
    }
}