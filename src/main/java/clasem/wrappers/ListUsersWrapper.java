package clasem.wrappers;

import clasem.entities.Authority;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class ListUsersWrapper {

    Long id;
    String username;
    private List<Authority> authorities;
    Boolean enabled;

    public ListUsersWrapper() {
    }

    public ListUsersWrapper(Long id, String username, List<Authority> authorities, Boolean enabled) {
        this.id = id;
        this.username = username;
        this.authorities = authorities;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "ListUsersWrapper{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", authorities=" + authorities +
                ", enabled=" + enabled +
                '}';
    }
}
