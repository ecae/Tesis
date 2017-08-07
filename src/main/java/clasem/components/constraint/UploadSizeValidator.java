package clasem.components.constraint;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UploadSizeValidator implements ConstraintValidator<UploadSizeConstraint, MultipartFile> {

    private long min;

    private long max;

    @Override
    public void initialize(UploadSizeConstraint file) {
        this.min = file.min();
        this.max = file.max();
    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        if (file == null || file.isEmpty()) {
            return true;
        }
        long size = file.getSize();
        return min <= size && size <= max;
    }

}