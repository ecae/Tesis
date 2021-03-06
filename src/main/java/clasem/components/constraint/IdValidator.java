package clasem.components.constraint;

import clasem.services.FieldValueExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdValidator implements ConstraintValidator<IdConstraint, String> {

    @Autowired
    private ApplicationContext applicationContext;

    private FieldValueExists service;

    @Override
    public void initialize(IdConstraint idConstraint) {
        Class<? extends FieldValueExists> clazz = idConstraint.service();
        String serviceQualifier = idConstraint.serviceQualifier();

        if (!serviceQualifier.equals("")) {
            this.service = this.applicationContext.getBean(serviceQualifier, clazz);
        } else {
            this.service = this.applicationContext.getBean(clazz);
        }
    }

    @Override
    public boolean isValid(String id, ConstraintValidatorContext context) {
        return ( id != null && id.matches("^[1-9]\\d*$") && !this.service.fieldIdExists(id));
    }

}