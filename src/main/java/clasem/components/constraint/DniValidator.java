package clasem.components.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DniValidator implements ConstraintValidator<DniConstraint, String> {

    @Override
    public void initialize(DniConstraint dniConstraint) {
    }

    @Override
    public boolean isValid(String cellPhoneField, ConstraintValidatorContext context) {
        if(cellPhoneField == null){
            return true;
        }
        return cellPhoneField.matches("^([7][0-9]{7})$");
    }
}