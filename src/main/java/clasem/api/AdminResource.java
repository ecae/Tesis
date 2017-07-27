package clasem.api;

import clasem.api.exceptions.AlreadyExistUserFieldException;
import clasem.api.exceptions.InvalidFieldModifyUserException;
import clasem.api.exceptions.NotFoundUserIdException;
import clasem.controllers.UserController;
import clasem.services.impl.ErrorService;
import clasem.wrappers.CreateUserWrapper;
import clasem.wrappers.EditUserWrapper;
import clasem.wrappers.ListUsersWrapper;
import clasem.wrappers.UserModifyWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;


@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminResource {


    private UserController userController;
    private ErrorService errorService;

    @Autowired
    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    @Autowired
    public void setErrorService(ErrorService errorService) {
        this.errorService = errorService;
    }

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

        return userController.createUser(createUserWrapper);

    }

    @RequestMapping(value = "/user/{id}/edit",method = RequestMethod.PUT)
    public ResponseEntity userModify(@Min(value = 1, message = "el id tiene que ser mayor a 0") @PathVariable Long id , @Valid @RequestBody UserModifyWrapper userModifyWrapper , Errors errors) throws InvalidFieldModifyUserException {

        if (errors.hasErrors()) {
            return errorService.getListError(errors);
        }

        return userController.userModify(id,userModifyWrapper);
    }

    @RequestMapping(value ="/user/{id}",method = RequestMethod.DELETE)
    public ResponseEntity userDestroy(@Min(value = 1, message = "el id tiene que ser mayor a 0") @PathVariable Long id )  throws NotFoundUserIdException{
        return userController.userDelete(id);
    }

}

