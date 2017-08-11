package clasem.services;

import clasem.entities.core.AssignmentMachine;
import clasem.entities.core.Machine;
import clasem.entities.user.User;
import clasem.wrappers.AssignmentMachine.EditAssignmentMachineWrapper;
import clasem.wrappers.AssignmentMachine.ListAssignmentMachineWrapper;
import clasem.wrappers.AssignmentMachine.UpdateAssignmentMachineWrapper;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AssignmentMachineService extends FieldValueExists {
    void createAssignment(String Description, long id_user, int id_machinee);
    List<ListAssignmentMachineWrapper> listAssignments();
    EditAssignmentMachineWrapper findById(int id);
    ResponseEntity updateAssignment(AssignmentMachine assignmentMachine, String description, User user, Machine machine);
}
