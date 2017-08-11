package clasem.converter;

import clasem.entities.core.AssignmentMachine;
import clasem.entities.core.Machine;
import clasem.entities.user.User;
import clasem.wrappers.AssignmentMachine.EditAssignmentMachineWrapper;
import clasem.wrappers.AssignmentMachine.ListAssignmentMachineWrapper;
import clasem.wrappers.AssignmentMachine.UpdateAssignmentMachineWrapper;
import org.springframework.stereotype.Component;

@Component
public class AssignmentMachineConvert {

    public AssignmentMachine assignmentMachine(String description, User user, Machine machine) {
        return new AssignmentMachine(description, user, machine);
    }

    public ListAssignmentMachineWrapper AssignmentMachine2ListAssignmentMachineWrapper(AssignmentMachine assignmentMachine) {
        ListAssignmentMachineWrapper listAssignmentMachineWrapper = new ListAssignmentMachineWrapper();
        listAssignmentMachineWrapper.setId(assignmentMachine.getId());
        listAssignmentMachineWrapper.setDescription(assignmentMachine.getDescription());
        listAssignmentMachineWrapper.setOperator(assignmentMachine.getUser().getFirstname()+" "+assignmentMachine.getUser().getLastname());
        listAssignmentMachineWrapper.setMachine(assignmentMachine.getMachine().getNamemachine());
        return listAssignmentMachineWrapper;
    }

    public EditAssignmentMachineWrapper assignmentMachine2EEditAssignmentMachineWrapper(AssignmentMachine assignmentMachine) {
        return new EditAssignmentMachineWrapper(assignmentMachine.getId(), assignmentMachine.getDescription(), assignmentMachine.getUser().getId(), assignmentMachine.getMachine().getId());
    }

    public AssignmentMachine UpdateAssigment2AssginmentMachine(AssignmentMachine assignmentMachine, String description, User user, Machine machine) {
        assignmentMachine.setDescription(description);
        assignmentMachine.setUser(user);
        assignmentMachine.setMachine(machine);
        return assignmentMachine;
    }
}
