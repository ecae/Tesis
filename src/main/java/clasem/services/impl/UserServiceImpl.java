package clasem.services.impl;

import clasem.converter.UserConverter;
import clasem.entities.User;
import clasem.repositories.UserRepository;
import clasem.services.UserService;
import clasem.wrappers.CreateUserWrapper;
import clasem.wrappers.EditUserWrapper;
import clasem.wrappers.ListUsersWrapper;
import clasem.wrappers.UserModifyWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public List<ListUsersWrapper> allUsers() {

        List<User> users = userRepository.findAll();
        List<ListUsersWrapper> listUsersWrappers = new ArrayList<ListUsersWrapper>();

        for (User user : users) {
            listUsersWrappers.add(userConverter.user2ConvertListUsersWrapper(user));
        }

        return listUsersWrappers;

    }

    @Override
    public EditUserWrapper findById(Long id)  {

        User user = userRepository.findById(id);
        if (null == user) {
            return  null;
        }
        return userConverter.user2EditUserWrapper(user);
    }

    @Override
    public void addUser(CreateUserWrapper createUserWrapper) {
        userRepository.save(userConverter.createUserWrapper2user(createUserWrapper));
    }

    @Override
    public ResponseEntity userModify(User user, UserModifyWrapper userModifyWrapper) {
        userRepository.save(userConverter.userModifyWrapper2User(user,userModifyWrapper));
        return new ResponseEntity("Usuario modificado correctamente", HttpStatus.OK);
    }
}
