package clasem.wrappers;

import clasem.entities.AuthorityName;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserModifyWrapper {

    @Size(min = 5,max = 10)
    String username;

    @Size(min = 3,max = 20)
    String firstname;

    @Size(min = 3,max = 20)
    String lastname;

    @Size(min = 5,max = 20)
    String password;

    @Email(message = "Ingrese un email valido")
    String email;

    boolean enabled;

    @Pattern(regexp="^(ROLE_ADMIN|ROLE_USER)$",message="El rol establecido no es validp")
    String rol;

    public UserModifyWrapper() {
    }

    public UserModifyWrapper(String username, String firstname, String lastname, String password, String email, boolean enabled, String rol) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRol() {
        return rol;
    }

    public AuthorityName AuthorityRol() {
        if(this.rol != null) {
            AuthorityName authorityName = AuthorityName.valueOf(rol);
            return authorityName;
        }
        return null;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String rolString() {
        return rol;
    }

    @Override
    public String toString() {
        return "UserModifyWrapper{" +
                "username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", rol='" + rol + '\'' +
                '}';
    }
}