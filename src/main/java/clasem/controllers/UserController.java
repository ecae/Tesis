package clasem.controllers;

import clasem.entities.Authority;
import clasem.entities.AuthorityName;
import clasem.entities.User;
import clasem.repositories.UserRepository;
import clasem.security.JwtTokenUtil;
import clasem.services.UserService;
import clasem.services.impl.UserServiceImpl;
import clasem.wrappers.CreateUserWrappers;
import clasem.wrappers.EditUserWrapper;
import clasem.wrappers.JwtUserWrapper;
import clasem.wrappers.ListUsersWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashSet;
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

    public ResponseEntity createUser(CreateUserWrappers createUserWrappers) {

        if( userRepository.findByUsername(createUserWrappers.getUsername()) != null) {
            return new ResponseEntity("Usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        if(userRepository.findByEmail(createUserWrappers.getEmail()) != null) {
            return new ResponseEntity("Email  ya existe", HttpStatus.BAD_REQUEST);
        }

        if(!userService.addUser(createUserWrappers)){
            return new ResponseEntity("error al crea el usuario",HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("usuario creado correctamente",HttpStatus.OK);

    }
}
