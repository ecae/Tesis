package clasem.api;

import clasem.controllers.UserController;
import clasem.entities.User;
import clasem.wrappers.EditUserWrapper;
import clasem.wrappers.ListUsersWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminResource {

    @Autowired
    private UserController userController;

    @RequestMapping(method = RequestMethod.GET)
    public String find() {
        return "This resource is protected";
    }


    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<ListUsersWrapper> allUsers() {
        return userController.allUsers();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public EditUserWrapper findUserById(@PathVariable Long id){
        return userController.findById(id);
    }
    
}

