package clasem.services;

import clasem.entities.user.User;
import clasem.wrappers.CreateUserWrapper;
import clasem.wrappers.EditUserWrapper;
import clasem.wrappers.ListUsersWrapper;
import clasem.wrappers.UserModifyWrapper;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService extends FieldValueExists{

    public abstract List<ListUsersWrapper> allUsers();
    public abstract EditUserWrapper findById(Long id);
    public abstract void addUser(CreateUserWrapper createUserWrapper);
    public abstract ResponseEntity userModify(User user, UserModifyWrapper userModifyWrapper);
}
