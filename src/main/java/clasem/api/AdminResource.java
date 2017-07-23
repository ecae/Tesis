package clasem.api;

import clasem.api.exceptions.AlreadyExistUserFieldException;
import clasem.api.exceptions.InvalidUserFieldException;
import clasem.api.exceptions.NotFoundUserIdException;
import clasem.controllers.UserController;
import clasem.services.impl.ErrorService;
import clasem.wrappers.CreateUserWrapper;
import clasem.wrappers.EditUserWrapper;
import clasem.wrappers.ErrorWrapper;
import clasem.wrappers.ListUsersWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminResource {

    @Autowired
    private UserController userController;

    @Autowired
    private ErrorService errorService;

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<ListUsersWrapper> allUsers() {
        return userController.allUsers();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public EditUserWrapper findUserById(@PathVariable Long id) throws NotFoundUserIdException {
        return userController.findById(id);
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public ResponseEntity addUser(@Valid @RequestBody CreateUserWrapper createUserWrapper, Errors errors) throws AlreadyExistUserFieldException{

        if (errors.hasErrors()) {
            return errorService.getListError(errors);
        }

        if (! userController.createUser(createUserWrapper)){
            throw new AlreadyExistUserFieldException();
        }
        return new ResponseEntity("Usuario creado correctamente", HttpStatus.OK);
    }

}

