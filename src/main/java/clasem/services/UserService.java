package clasem.services;

import clasem.wrappers.ListUsersWrapper;

import java.util.List;

public interface UserService {

    public abstract List<ListUsersWrapper> allUsers();

}
