package clasem.components.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = UploadSizeValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface UploadSizeConstraint {
    String message() default "Tamaño del fichero no permitido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    /**
            * @return size file size in bytes must be higher or equal to
	 */
    long min() default 0;
    /**
     * @return size the file size in bytes must be lower or equal to
     */
    long max() default Long.MAX_VALUE;

    /**
     * Defines several {@link UploadSizeConstraint} annotations on the same element.
     *
     * @see UploadSizeConstraint
     */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        UploadSizeConstraint[] value();
    }

}