package clasem.wrappers.user;

import clasem.components.constraint.CellPhoneConstraint;
import clasem.components.constraint.DniConstraint;
import clasem.components.constraint.IdConstraint;
import clasem.components.constraint.UniqueConstraint;
import clasem.entities.user.AuthorityName;
import clasem.services.UserService;
import org.hibernate.validator.constraints.Email;

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

    @DniConstraint
    String dni;

    @CellPhoneConstraint
    String cellphone;

    boolean enabled;

    @Pattern(regexp="^(ROLE_ADMIN|ROLE_USER)$",message="El rol establecido no es valido")
    String rol;

    public UserModifyWrapper() {
    }

    public UserModifyWrapper(String username, String firstname, String lastname, String password, String email, String dni, String cellphone, boolean enabled, String rol) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.dni = dni;
        this.cellphone = cellphone;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
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
                ", dni='" + dni + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", enabled=" + enabled +
                ", rol='" + rol + '\'' +
                '}';
    }
}
