package clasem.wrappers;

import clasem.entities.AuthorityName;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CreateUserWrapper {

    @Size(min = 5,max = 10)
    String username;

    @Size(min = 3,max = 10)
    String firstname;

    @Size(min = 3,max = 10)
    String lastname;

    @Size(min = 5,max = 20)
    String password;

    @Email(message = "Ingrese un email valido")
    String email;

    @Pattern(regexp="^(ROLE_ADMIN|ROLE_USER)$",message="Rol no es valido")
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
