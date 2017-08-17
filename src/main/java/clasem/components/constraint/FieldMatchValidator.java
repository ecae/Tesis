package clasem.components.constraint;

import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object>
{
    private String firstFieldName;
    private String secondFieldName;
    private String help;
    private String errorMessage;

    @Override
    public void initialize(final FieldMatch constraintAnnotation)
    {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
        help = constraintAnnotation.help();
        errorMessage = constraintAnnotation.errorMessage();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext cvc){
        boolean toReturn = false;

        try {
            final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
            final Object secondObj = BeanUtils.getProperty(value, secondFieldName);


            if(firstObj == null){
                return false;
            }

            toReturn = swithTM(firstObj.toString(),help,secondObj.toString());

        }
        catch (final Exception e){
            System.out.println(e.toString());
        }
        //If the validation failed
        if(!toReturn) {
            cvc.disableDefaultConstraintViolation();
            //In the initialiaze method you get the errorMessage: constraintAnnotation.message();
            cvc.buildConstraintViolationWithTemplate(errorMessage).addNode(secondFieldName).addConstraintViolation();
        }
        return toReturn;
    }

    private boolean swithTM(String mtype,String help,String value){
        boolean treturn =  false;
        switch (mtype){
            case "HOROMETER":
                if(help.equals("horometer")){
                    treturn = value != null && (Integer.parseInt(value) > 0); break;
                }
                treturn = true; break;
            case "DAYS":
                if (!help.equals("horometer")){
                    if (help.equals("days")){
                        treturn = value != null &&(Integer.parseInt(value) > 0); break;
                    }
                    treturn = !value.isEmpty();break;
                }
                treturn=true;break;
        }
        return treturn;
    }


}