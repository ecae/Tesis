package clasem.components.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckDateValidator implements ConstraintValidator<CheckDate, String> {

    private String pattern;

    @Override
    public void initialize(CheckDate constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
        if ( object.isEmpty() ) {
            return true;
        }

        try {
            Date date = new SimpleDateFormat(pattern).parse(object);
            System.out.println("*****************DATE: "+date);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}