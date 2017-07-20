package clasem.converter;

import clasem.entities.User;
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
}
