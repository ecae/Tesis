package clasem.services;

import clasem.entities.user.User;
import clasem.wrappers.user.CreateUserWrapper;
import clasem.wrappers.user.EditUserWrapper;
import clasem.wrappers.user.ListUsersWrapper;
import clasem.wrappers.user.UserModifyWrapper;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService extends FieldValueExists{

    public abstract List<ListUsersWrapper> allUsers();
    public abstract EditUserWrapper findById(Long id);
    public abstract void addUser(CreateUserWrapper createUserWrapper);
    public abstract ResponseEntity userModify(User user, UserModifyWrapper userModifyWrapper);
}
