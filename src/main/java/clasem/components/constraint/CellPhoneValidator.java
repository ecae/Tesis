package clasem.components.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CellPhoneValidator implements ConstraintValidator<CellPhoneConstraint, String> {

    @Override
    public void initialize(CellPhoneConstraint cellPhoneConstraint) {
    }

    @Override
    public boolean isValid(String cellPhoneField, ConstraintValidatorContext context) {
        if(cellPhoneField == null){
            return true;
        }
        return cellPhoneField.matches("^([9][0-9]{8})$");
    }
}