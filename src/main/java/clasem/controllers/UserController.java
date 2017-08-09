package clasem.controllers;

import clasem.api.exceptions.InvalidFieldModifyUserException;
import clasem.entities.user.User;
import clasem.repositories.UserRepository;
import clasem.security.JwtTokenUtil;
import clasem.services.UserService;
import clasem.wrappers.user.*;
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

    public EditUserWrapper findById(Long id) {

        EditUserWrapper editUserWrapper= userService.findById( id);
        return editUserWrapper;
    }

    public ResponseEntity createUser(CreateUserWrapper createUserWrapper) {
            userService.addUser(createUserWrapper);
            return new ResponseEntity("Usuario creado correctamente", HttpStatus.OK);
    }

    public ResponseEntity userModify(long id ,UserModifyWrapper userModifyWrapper) throws InvalidFieldModifyUserException {

        User user = userRepository.findOne(id);
        User F2Username =  userRepository.findByUsername(userModifyWrapper.getUsername());
        User F2Dni = userRepository.findByDni(userModifyWrapper.getDni());
        User F2Email = userRepository.findByEmail(userModifyWrapper.getEmail());
        User F2Cellphone = userRepository.findByCellphone(userModifyWrapper.getCellphone());

        if ((F2Username != null) && (user.getId() != F2Username.getId())) {
            throw new InvalidFieldModifyUserException("Usuario ya esta en uso");
        }else if((F2Dni != null) && (user.getId() != F2Dni.getId())){
            throw new InvalidFieldModifyUserException("Dni ya esta en uso");
        }else if ((F2Email != null) && (user.getId() != F2Email.getId())){
            throw new InvalidFieldModifyUserException("Email ya esta en uso");
        }else if ((F2Cellphone != null) && (user.getId() != F2Cellphone.getId())){
            throw new InvalidFieldModifyUserException("Celular ya esta en uso");
        }else{
            return userService.userModify(user,userModifyWrapper);
        }

    }

    public ResponseEntity userDelete(long id) {

        userRepository.delete(id);
        return new ResponseEntity("Usuario eliminado correctamente", HttpStatus.OK);
    }
}
