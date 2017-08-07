package clasem.services.impl;

import clasem.converter.UserConverter;
import clasem.entities.user.User;
import clasem.repositories.UserRepository;
import clasem.services.UserService;
import clasem.wrappers.user.CreateUserWrapper;
import clasem.wrappers.user.EditUserWrapper;
import clasem.wrappers.user.ListUsersWrapper;
import clasem.wrappers.user.UserModifyWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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

    @Override
    public boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException {
        Assert.notNull(fieldName);

        if (!fieldName.equals("username") && !fieldName.equals("email") && !fieldName.equals("dni") && !fieldName.equals("cellphone")) {
            throw new UnsupportedOperationException("Field name not supported");
        }

        if (value == null) {
            return false;
        }

        User user = switchUnique(fieldName,value);

        return verifyNullUser(user);
    }

    public User switchUnique(String f, Object value) {
        User user = null;

        switch (f) {
            case "" : return null;
            case "username" :user= userRepository.findByUsername(value.toString()); break;
            case "email" :user= userRepository.findByEmail(value.toString()); break;
            case "dni" :user= userRepository.findByDni(value.toString()); break;
            case "cellphone" :user= userRepository.findByCellphone(value.toString()); break;
        }
        return user;
    }

    @Override
    public boolean fieldIdExists(String id) throws UnsupportedOperationException {

        if (id == null) {
            return false;
        }
        Long nid = Long.parseLong(id);
        User user =userRepository.findOne(nid);

        return verifyNullUser(user);
    }

    public boolean verifyNullUser(User user) {

        if (null != user) {
            return false;
        }
        return true;
    }
}
