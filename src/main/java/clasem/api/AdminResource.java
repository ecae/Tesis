package clasem.api;

import clasem.api.exceptions.AlreadyExistUserFieldException;
import clasem.api.exceptions.InvalidFieldModifyUserException;
import clasem.api.exceptions.NotFoundUserIdException;
import clasem.components.constraint.IdConstraint;
import clasem.controllers.UserController;
import clasem.wrappers.CreateUserWrapper;
import clasem.wrappers.EditUserWrapper;
import clasem.wrappers.ListUsersWrapper;
import clasem.wrappers.UserModifyWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@Validated
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminResource {

    private UserController userController;

    @Autowired
    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<ListUsersWrapper> allUsers() {
        return userController.allUsers();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public EditUserWrapper findUserById(@Valid @IdConstraint @PathVariable(value = "id")  String id) throws NotFoundUserIdException {
        Long iden = Long.parseLong(id);
        return userController.findById(iden);
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public ResponseEntity addUser(@Valid @RequestBody CreateUserWrapper createUserWrapper, Errors errors) throws AlreadyExistUserFieldException{

        return userController.createUser(createUserWrapper);
    }

    @RequestMapping(value = "/user/{id}/edit",method = RequestMethod.PUT)
    public ResponseEntity userModify(@Valid @IdConstraint @PathVariable(value = "id")  String id , @Valid @RequestBody UserModifyWrapper userModifyWrapper , Errors errors) throws InvalidFieldModifyUserException {

        Long iden = Long.parseLong(id);
        return userController.userModify(iden,userModifyWrapper);
    }

    @RequestMapping(value ="/user/{id}",method = RequestMethod.DELETE)
    public ResponseEntity userDestroy(@Valid @IdConstraint @PathVariable(value = "id")  String id )  throws NotFoundUserIdException {
        Long iden = Long.parseLong(id);
        return userController.userDelete(iden);
    }

}

