package clasem.wrappers;

import clasem.components.constraint.RolConstraint;
import clasem.entities.AuthorityName;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CreateUserWrapper {

    @NotEmpty
    @Size(min = 5,max = 20)
    String username;

    @NotEmpty
    @Size(min = 3,max = 20)
    String firstname;

    @NotEmpty
    @Size(min = 3,max = 20)
    String lastname;

    @NotEmpty
    @Size(min = 5,max = 20)
    String password;

    @NotEmpty
    @Email(message = "Ingrese un email válido")
    String email;

    @RolConstraint
    String rol;

    public CreateUserWrapper() {
    }

    public CreateUserWrapper(String username, String firstname, String lastname, String password, String email, String rol) {
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
         AuthorityName authorityName = AuthorityName.valueOf(rol);
         return authorityName;
    }

    public void setRol(String rol) {
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
                ", rol='" + rol + '\'' +
                '}';
    }
}
