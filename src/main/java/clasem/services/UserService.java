package clasem.services;

import clasem.wrappers.EditUserWrapper;
import clasem.wrappers.ListUsersWrapper;

import java.util.List;

public interface UserService {

    public abstract List<ListUsersWrapper> allUsers();
    public abstract EditUserWrapper findById(Long id);
}
