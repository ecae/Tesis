package clasem.wrappers;

import clasem.entities.AuthorityName;

public class CreateUserWrapper {

    String username;
    String firstname;
    String lastname;
    String password;
    String email;
    AuthorityName rol;

    public CreateUserWrapper() {
    }

    public CreateUserWrapper(String username, String firstname, String lastname, String password, String email, AuthorityName rol) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AuthorityName getRol() {
        return rol;
    }

    public void setRol(AuthorityName rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "CreateUserWrapper{" +
                "username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", rol=" + rol +
                '}';
    }
}
