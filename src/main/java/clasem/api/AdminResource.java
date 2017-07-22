package clasem.api;

import clasem.api.exceptions.AlreadyExistUserFieldException;
import clasem.api.exceptions.InvalidUserFieldException;
import clasem.controllers.UserController;
import clasem.wrappers.CreateUserWrapper;
import clasem.wrappers.EditUserWrapper;
import clasem.wrappers.ListUsersWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminResource {

    @Autowired
    private UserController userController;

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<ListUsersWrapper> allUsers() {
        return userController.allUsers();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public EditUserWrapper findUserById(@PathVariable Long id){
        return userController.findById(id);
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public void addUser(@RequestBody CreateUserWrapper createUserWrapper) throws InvalidUserFieldException, AlreadyExistUserFieldException{
        validateField(createUserWrapper.getUsername(), "usuario");
        validateField(createUserWrapper.getPassword(),"contraseña");
        if (! userController.createUser(createUserWrapper)){
            throw new AlreadyExistUserFieldException();
        }
    }

    private void validateField(String field, String msg) throws InvalidUserFieldException {
        if (field == null || field.isEmpty()) {
            throw new InvalidUserFieldException(msg);
        }
    }
    
}

