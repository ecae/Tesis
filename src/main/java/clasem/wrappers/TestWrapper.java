package clasem.wrappers;

import clasem.components.constraint.CellPhoneConstraint;
import clasem.components.constraint.DniConstraint;
import clasem.components.constraint.IdConstraint;
import clasem.components.constraint.UniqueConstraint;
import clasem.services.UserService;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;

public class TestWrapper {


    @IdConstraint(service = UserService.class)
    String id;

    @Size(min = 5, max = 20)
    @UniqueConstraint(service = UserService.class, fieldName = "username", message = "{username ya ha sido registrado}")
    String username;


    @Email(message = "Ingrese un email válido")
    @UniqueConstraint(service = UserService.class, fieldName = "email", message = "{email ya ha sido registrado}")
    String email;

    @DniConstraint
    @UniqueConstraint(service = UserService.class, fieldName = "dni", message = "{dni ya ha sido registrado}")
    String dni;

    @CellPhoneConstraint
    @UniqueConstraint(service = UserService.class, fieldName = "cellphone", message = "{celular ya ha sido registrado}")
    String cellphone;

    public TestWrapper() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username+"-"+this.id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email+"-"+this.id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni+"-"+this.id;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCellphone() {
        return cellphone+"-"+this.id;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @Override
    public String toString() {
        return "TestWrapper{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", dni='" + dni + '\'' +
                ", cellphone='" + cellphone + '\'' +
                '}';
    }
}
