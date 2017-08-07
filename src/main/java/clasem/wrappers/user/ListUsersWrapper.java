package clasem.wrappers.user;

public class ListUsersWrapper {

    Long id;
    String username;
    String rol;
    Boolean enabled;

    public ListUsersWrapper() {
    }

    public ListUsersWrapper(Long id, String username, String rol, Boolean enabled) {
        this.id = id;
        this.username = username;
        this.rol = rol;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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
                ", rol='" + rol + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
