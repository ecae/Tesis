package clasem.converter;

import clasem.entities.user.Authority;
import clasem.entities.user.AuthorityName;
import clasem.entities.user.User;
import clasem.wrappers.user.CreateUserWrapper;
import clasem.wrappers.user.EditUserWrapper;
import clasem.wrappers.user.ListUsersWrapper;
import clasem.wrappers.user.UserModifyWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserConverter {

    private static final Log log = LogFactory.getLog(UserConverter.class);

    public ListUsersWrapper user2ConvertListUsersWrapper(User user) {

        ListUsersWrapper listUsersWrapper = new ListUsersWrapper();
        listUsersWrapper.setId(user.getId());
        listUsersWrapper.setUsername(user.getUsername());
        listUsersWrapper.setRol(getRol(user.getAuthorities()));
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
        editUserWrapper.setDni(user.getDni());
        editUserWrapper.setCellphone(user.getCellphone());
        editUserWrapper.setRol(getRol(user.getAuthorities()));
        editUserWrapper.setEnabled(user.getEnabled());
        return editUserWrapper;
    }

    public User createUserWrapper2user(CreateUserWrapper createUserWrapper) {

        User user = new User();
        user.setUsername(createUserWrapper.getUsername());
        user.setFirstname(createUserWrapper.getFirstname());
        user.setLastname(createUserWrapper.getLastname());
        user.setPassword(createUserWrapper.getPassword());
        user.setEmail(createUserWrapper.getEmail());
        user.setDni(createUserWrapper.getDni());
        user.setCellphone(createUserWrapper.getCellphone());
        user.setEnabled(true);
        user.setLastPasswordResetDate(new Date());
        user.setAuthorities(setAuthorities(createUserWrapper.getRol()));
        return user;
    }

    public User userModifyWrapper2User(User user, UserModifyWrapper userModifyWrapper) {

        user.setUsername(userModifyWrapper.getUsername());
        user.setFirstname(userModifyWrapper.getFirstname());
        user.setLastname(userModifyWrapper.getLastname());
        user.setEmail(userModifyWrapper.getEmail());
        user.setDni(userModifyWrapper.getDni());
        user.setCellphone(userModifyWrapper.getCellphone());
        user.setEnabled(userModifyWrapper.isEnabled());
        user.setAuthorities(setAuthorities(userModifyWrapper.AuthorityRol()));
        if (userModifyWrapper.getPassword() != null) {
            user.setPassword(userModifyWrapper.getPassword());
            user.setLastPasswordResetDate(new Date());
        }
        return user;
    }

    public String getRol(List<Authority> authorities) {
        if (authorities.size() < 2) {
            return "ROLE_USER";
        } else {
            return "ROLE_ADMIN";
        }
    }

    public List<Authority> setAuthorities(AuthorityName authorityName) {

        List<Authority> authorities = new ArrayList<Authority>();
        Authority authorityUser = new Authority();
        Authority authorityAdmin = new Authority();
        authorityUser.setId(1);
        authorityUser.setName(AuthorityName.ROLE_USER);
        authorityAdmin.setId(2);
        authorityAdmin.setName(AuthorityName.ROLE_ADMIN);

        if (authorityName == AuthorityName.ROLE_ADMIN) {
            authorities.add(authorityUser);
            authorities.add(authorityAdmin);
            return authorities;
        } else {
            authorities.add(authorityUser);
            return authorities;
        }
    }


}
