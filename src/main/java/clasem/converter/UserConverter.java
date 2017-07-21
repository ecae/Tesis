package clasem.converter;

import clasem.config.SecurityUtility;
import clasem.entities.Authority;
import clasem.entities.AuthorityName;
import clasem.entities.User;
import clasem.wrappers.CreateUserWrappers;
import clasem.wrappers.EditUserWrapper;
import clasem.wrappers.ListUsersWrapper;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public User createUserWrapper2user(CreateUserWrappers createUserWrappers) {

        List<Authority> authorities= new ArrayList<Authority>();
        Authority authorityUser = new Authority();
        authorityUser.setId(1);
        authorityUser.setName(AuthorityName.ROLE_USER);
        Authority authorityAdmin = new Authority();
        authorityAdmin.setId(2);
        authorityAdmin.setName(AuthorityName.ROLE_ADMIN);

        authorities.add(authorityUser);

        User user = new User();
        user.setUsername(createUserWrappers.getUsername());
        user.setFirstname(createUserWrappers.getFirstname());
        user.setLastname(createUserWrappers.getLastname());
        user.setPassword(SecurityUtility.passwordEncoder().encode( createUserWrappers.getPassword()));
        user.setEmail(createUserWrappers.getEmail());
        user.setEnabled(true);
        user.setLastPasswordResetDate(new Date());
        if(createUserWrappers.getRol() != "admin") {
            user.getAuthorities().addAll(authorities);
            return user;
        }
        authorities.add(authorityAdmin);
        user.getAuthorities().addAll(authorities);
        return user;
    }
}
