package clasem.components.constraint;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ImageValidator implements ConstraintValidator<ImageConstraint, MultipartFile> {

    @Override
    public void initialize(ImageConstraint image) {
    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        if (file == null) {
            return true;
        }
        if(getFileType(file).equalsIgnoreCase("image")) {
            return true;
        }
        return false;
    }

    private String getFileType(MultipartFile file) {
        String type = file.getContentType().split("/", 2)[0];
        return type;

    }
}