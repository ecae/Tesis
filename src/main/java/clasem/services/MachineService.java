package clasem.services;

import clasem.entities.core.Machine;
import clasem.wrappers.machine.CreateMachineWrapper;
import clasem.wrappers.machine.EditMachineWrapper;
import clasem.wrappers.machine.ListMachineWrapper;
import clasem.wrappers.machine.MachineModifyWrapper;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MachineService extends FieldValueExists {

    List<ListMachineWrapper> allMachines();
    EditMachineWrapper findById(int id);
    void saveMachine(CreateMachineWrapper createMachineWrapper);
    ResponseEntity updateMachine(Machine machine, MachineModifyWrapper machineModifyWrapper);
}
