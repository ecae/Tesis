package clasem.controllers;

import clasem.repositories.UserRepository;
import clasem.security.JwtTokenUtil;
import clasem.services.UserService;
import clasem.wrappers.CreateUserWrapper;
import clasem.wrappers.EditUserWrapper;
import clasem.wrappers.JwtUserWrapper;
import clasem.wrappers.ListUsersWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public JwtUserWrapper deatilsUserAthenticated(String token) {

        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUserWrapper user = (JwtUserWrapper) userDetailsService.loadUserByUsername(username);
        return user;
    }

    public List<ListUsersWrapper> allUsers() {
        return userService.allUsers();
    }

    public EditUserWrapper findById(Long id) {
        return userService.findById( id);
    }

    public boolean createUser(CreateUserWrapper createUserWrapper) {

        if( null == userRepository.findByUsername(createUserWrapper.getUsername())) {
            userService.addUser(createUserWrapper);
            return true;
        } else {
            return false;
        }

    }
}
