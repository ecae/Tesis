package clasem.converter;

import clasem.config.SecurityUtility;
import clasem.entities.Authority;
import clasem.entities.AuthorityName;
import clasem.entities.User;
import clasem.wrappers.CreateUserWrapper;
import clasem.wrappers.EditUserWrapper;
import clasem.wrappers.ListUsersWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserConverter {

    private static final Log log = LogFactory.getLog(UserConverter.class);

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

    public User createUserWrapper2user(CreateUserWrapper createUserWrapper) {

        log.info("el rol que biene es: "+ createUserWrapper.getRol());

        List<Authority> authorities= new ArrayList<Authority>();
        Authority authorityUser = new Authority();
        Authority authorityAdmin = new Authority();
        authorityUser.setId(1);
        authorityUser.setName(AuthorityName.ROLE_USER);
        authorityAdmin.setId(2);
        authorityAdmin.setName(AuthorityName.ROLE_ADMIN);

        if(createUserWrapper.getRol() == AuthorityName.ROLE_ADMIN) {
            log.info("entra al if con este rol: '"+ createUserWrapper.getRol()+"'");
            authorities.add(authorityUser);
            authorities.add(authorityAdmin);
        }else {
            log.info("entra al else con este rol: '"+ createUserWrapper.getRol()+"'");
            authorities.add(authorityUser);
        }

        User user = new User();
        user.setUsername(createUserWrapper.getUsername());
        user.setFirstname(createUserWrapper.getFirstname());
        user.setLastname(createUserWrapper.getLastname());
        user.setPassword(SecurityUtility.passwordEncoder().encode( createUserWrapper.getPassword()));
        user.setEmail(createUserWrapper.getEmail());
        user.setEnabled(true);
        user.setLastPasswordResetDate(new Date());
        user.setAuthorities(authorities);
        return user;
    }
}
