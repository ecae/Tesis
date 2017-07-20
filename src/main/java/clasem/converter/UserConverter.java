package clasem.converter;

import clasem.entities.User;
import clasem.wrappers.EditUserWrapper;
import clasem.wrappers.ListUsersWrapper;
import org.springframework.stereotype.Controller;

@Controller
public class UserConverter {

    public ListUsersWrapper user2ConvertListUsersWrapper(User user) {

        ListUsersWrapper listUsersWrapper = new ListUsersWrapper();
        listUsersWrapper.setId(user.getId());
        listUsersWrapper.setUsername(user.getUsername());
        listUsersWrapper.setAuthorities(user.getAuthorities());
        listUsersWrapper.setEnabled(user.getEnabled());
        return listUsersWrapper;
    }

    public EditUserWrapper user2EditUserWrapper(User user) {

        EditUserWrapper editUserWrapper = new EditUserWrapper();
        editUserWrapper.setId(user.getId());
        editUserWrapper.setUsername(user.getUsername());
        editUserWrapper.setFirstname(user.getFirstname());
        editUserWrapper.setLastname(user.getLastname());
        editUserWrapper.setEmail(user.getEmail());
        editUserWrapper.setAuthorities(user.getAuthorities());
        editUserWrapper.setEnabled(user.getEnabled());
        return editUserWrapper;
    }
}
