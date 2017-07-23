package clasem.services.impl;

import antlr.collections.List;
import clasem.wrappers.ErrorWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.ArrayList;

@Service
public class ErrorService {

    public ResponseEntity getListError(Errors errors) {

            java.util.List<ErrorWrapper> errorsList = new ArrayList<ErrorWrapper>();
            for (FieldError error:errors.getFieldErrors()) {
                ErrorWrapper errorWrapper = new ErrorWrapper();
                errorWrapper.setMessage(error.getDefaultMessage());
                errorWrapper.setField(error.getField());
                errorsList.add(errorWrapper);
            }
            return new ResponseEntity(errorsList, HttpStatus.BAD_REQUEST);

    }
}
