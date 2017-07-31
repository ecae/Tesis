package clasem.api;

import clasem.api.exceptions.AlreadyExistUserFieldException;
import clasem.api.exceptions.InvalidFieldModifyUserException;
import clasem.api.exceptions.NotFoundUserIdException;
import clasem.components.constraint.IdConstraint;
import clasem.components.constraint.UniqueConstraint;
import clasem.controllers.UserController;
import clasem.services.UserService;
import clasem.wrappers.*;
import org.hibernate.validator.constraints.Email;
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
    public EditUserWrapper findUserById(@Valid @IdConstraint(service = UserService.class) @PathVariable(value = "id")  String id) {
        Long iden = Long.parseLong(id);
        return userController.findById(iden);
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public ResponseEntity addUser(@Valid @RequestBody CreateUserWrapper createUserWrapper, Errors errors){

        return userController.createUser(createUserWrapper);
    }

    @RequestMapping(value = "/user/{id}/edit",method = RequestMethod.PUT)
    public ResponseEntity userModify(@Valid @IdConstraint(service = UserService.class) @PathVariable(value = "id")  String id , @Valid @RequestBody UserModifyWrapper userModifyWrapper , Errors errors) throws InvalidFieldModifyUserException {

        Long iden = Long.parseLong(id);
        return userController.userModify(iden,userModifyWrapper);
    }

    @RequestMapping(value ="/user/{id}",method = RequestMethod.DELETE)
    public ResponseEntity userDestroy(@Valid @IdConstraint(service = UserService.class) @PathVariable(value = "id")  String id ) {
        Long iden = Long.parseLong(id);
        return userController.userDelete(iden);
    }

    @RequestMapping(value ="/test",method = RequestMethod.POST)
    public String test(@Valid @RequestBody TestWrapper testWrapper, Errors errors)  {

        return "pasaron todas las validaciones usuario disponible: " + testWrapper.toString();
    }

}

