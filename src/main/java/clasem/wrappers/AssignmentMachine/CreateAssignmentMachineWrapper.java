package clasem.wrappers.AssignmentMachine;

import clasem.components.constraint.IdConstraint;
import clasem.components.constraint.UniqueConstraint;
import clasem.services.AssignmentMachineService;
import clasem.services.MachineService;
import clasem.services.UserService;
import org.hibernate.validator.constraints.NotEmpty;

public class CreateAssignmentMachineWrapper {

    @NotEmpty(message = "Ingrese una descripcion de la asignacion")
    private String description;

    @IdConstraint(service = UserService.class,message = "Usuario no existe")
    @UniqueConstraint(service = AssignmentMachineService.class, fieldName = "id_user")
    private String id_user;

    @IdConstraint(service = MachineService.class, message = "Maquinaria no existe")
    @UniqueConstraint(service = AssignmentMachineService.class, fieldName = "id_machine")
    private String id_machine;

    public CreateAssignmentMachineWrapper() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getId_machine() {
        return id_machine;
    }

    public void setId_machine(String id_machine) {
        this.id_machine = id_machine;
    }
}
