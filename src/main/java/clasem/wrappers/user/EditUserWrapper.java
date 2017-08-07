package clasem.wrappers.user;

public class EditUserWrapper {

    Long id;
    String username;
    String firstname;
    String lastname;
    String email;
    String dni;
    String cellphone;
    String rol;
    Boolean enabled;

    public EditUserWrapper() {
    }

    public EditUserWrapper(Long id, String username, String firstname, String lastname, String email, String dni, String cellphone, String rol, Boolean enabled) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dni = dni;
        this.cellphone = cellphone;
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
        return "EditUserWrapper{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", dni='" + dni + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", rol='" + rol + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
