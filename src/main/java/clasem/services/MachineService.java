package clasem.services;

import clasem.wrappers.machine.CreateMachineWrapper;
import clasem.wrappers.machine.EditMachineWrapper;
import clasem.wrappers.machine.ListMachineWrapper;

import java.util.List;

public interface MachineService extends FieldValueExists {

    List<ListMachineWrapper> allMachines();
    EditMachineWrapper findById(int id);
    void saveMachine(CreateMachineWrapper createMachineWrapper);
}
