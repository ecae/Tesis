package clasem.api;

import clasem.api.exceptions.AlreadyExistUserFieldException;
import clasem.api.exceptions.InvalidUserFieldException;
import clasem.controllers.UserController;
import clasem.entities.User;
import clasem.wrappers.CreateUserWrappers;
import clasem.wrappers.EditUserWrapper;
import clasem.wrappers.ListUsersWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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

    /*@RequestMapping(value="/user/create", method = RequestMethod.POST)
    public ResponseEntity addUser(HttpServletRequest request, @RequestBody HashMap<String, String> mapper) throws Exception {

        String username = mapper.get("username");
        String firstname = mapper.get("firstname");
        String lastname = mapper.get("lastname");
        String password = mapper.get("password");
        String email = mapper.get("email");
        String rol = mapper.get("rol");

        if(username == null && firstname == null && lastname == null && password == null && email == null && rol == null ){
            return new ResponseEntity("faltan datos",HttpStatus.BAD_REQUEST);
        }

        CreateUserWrappers createUserWrappers = new CreateUserWrappers(username,firstname,lastname,password,email,rol);
        return userController.createUser(createUserWrappers);
    }*/
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public void addUser(@RequestBody CreateUserWrappers createUserWrappers) throws InvalidUserFieldException, AlreadyExistUserFieldException{
        validateField(createUserWrappers.getUsername(), "usuario");
        validateField(createUserWrappers.getPassword(),"contraseña");
    }

    private void validateField(String field, String msg) throws InvalidUserFieldException {
        if (field == null || field.isEmpty()) {
            throw new InvalidUserFieldException(msg);
        }
    }
    
}

