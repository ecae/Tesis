package clasem.controllers;

import clasem.api.exceptions.AlreadyExistUserFieldException;
import clasem.api.exceptions.InvalidFieldModifyUserException;
import clasem.api.exceptions.NotFoundUserIdException;
import clasem.entities.User;
import clasem.repositories.UserRepository;
import clasem.security.JwtTokenUtil;
import clasem.services.UserService;
import clasem.wrappers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private JwtTokenUtil jwtTokenUtil;

    private UserDetailsService userDetailsService;

    private UserService userService;

    private UserRepository userRepository;

    @Autowired
    public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public JwtUserWrapper deatilsUserAthenticated(String token) {

        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUserWrapper user = (JwtUserWrapper) userDetailsService.loadUserByUsername(username);
        return user;
    }

    public List<ListUsersWrapper> allUsers() {
        return userService.allUsers();
    }

    public EditUserWrapper findById(Long id) throws NotFoundUserIdException {
        EditUserWrapper editUserWrapper= userService.findById( id);
        if (null == editUserWrapper) {
           throw new NotFoundUserIdException();
        }
        return editUserWrapper;
    }

    public ResponseEntity createUser(CreateUserWrapper createUserWrapper) throws AlreadyExistUserFieldException {

        if( null == userRepository.findByUsername(createUserWrapper.getUsername())) {
            userService.addUser(createUserWrapper);
            return new ResponseEntity("Usuario creado correctamente", HttpStatus.OK);
        } else {
            throw new AlreadyExistUserFieldException();
        }

    }

    public ResponseEntity userModify(long id ,UserModifyWrapper userModifyWrapper) throws InvalidFieldModifyUserException {

        User user = userRepository.findOne(id);

        if ((userRepository.findByUsername(userModifyWrapper.getUsername()) != null) && (user.getId() != userRepository.findByUsername(userModifyWrapper.getUsername()).getId())) {
            throw new InvalidFieldModifyUserException("\nUsuario ya existe");
        }else {
            return userService.userModify(user,userModifyWrapper);
        }

    }

    public ResponseEntity userDelete(long id) throws NotFoundUserIdException{

        User user = userRepository.findOne(id);
        if (null == user) {
            throw new NotFoundUserIdException();
        }
        userRepository.delete(id);
        return new ResponseEntity("Usuario eliminado correctamente", HttpStatus.OK);
    }
}
