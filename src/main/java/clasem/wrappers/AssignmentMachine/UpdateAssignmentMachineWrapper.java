package clasem.wrappers.AssignmentMachine;

import clasem.components.constraint.IdConstraint;
import clasem.services.MachineService;
import clasem.services.UserService;
import org.hibernate.validator.constraints.NotEmpty;

public class UpdateAssignmentMachineWrapper {

    @NotEmpty
    String description;

    @IdConstraint(service = UserService.class, message = "Usuario no existe")
    String id_user;

    @IdConstraint(service = MachineService.class, message = "Maquinaria no existe")
    String id_machine;


    public UpdateAssignmentMachineWrapper() {
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
