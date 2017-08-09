package clasem.converter;

import clasem.entities.core.Machine;
import clasem.wrappers.machine.CreateMachineWrapper;
import clasem.wrappers.machine.EditMachineWrapper;
import clasem.wrappers.machine.ListMachineWrapper;
import clasem.wrappers.machine.MachineModifyWrapper;
import org.springframework.stereotype.Component;

@Component
public class MachineConverter {

    public ListMachineWrapper machines2listMachineWrappers(Machine machine) {
        ListMachineWrapper listMachineWrapper = new ListMachineWrapper();
        listMachineWrapper.setId(machine.getId());
        listMachineWrapper.setMark(machine.getMark());
        listMachineWrapper.setModel(machine.getModel());
        listMachineWrapper.setNamemachine(machine.getNamemachine());
        return listMachineWrapper;
    }

    public EditMachineWrapper machine2EditMachineWrapper(Machine machine){
        EditMachineWrapper editMachineWrapper = new EditMachineWrapper();
        editMachineWrapper.setId(machine.getId());
        editMachineWrapper.setFabricator(machine.getFabricator());
        editMachineWrapper.setModel(machine.getModel());
        editMachineWrapper.setMark(machine.getMark());
        editMachineWrapper.setNamemachine(machine.getNamemachine());
        editMachineWrapper.setSerie(machine.getSerie());
        editMachineWrapper.setMachineImage(machine.getMachineImage());
        editMachineWrapper.setDatepurchase(machine.getDatepurchase());
        editMachineWrapper.setEnabled(machine.isEnabled());
        return editMachineWrapper;
    }

    public Machine createMachineWrapper2Machine(CreateMachineWrapper createMachineWrapper) {
        Machine machine = new Machine();
        machine.setFabricator(createMachineWrapper.getFabricator());
        machine.setModel(createMachineWrapper.getModel());
        machine.setMark(createMachineWrapper.getMark());
        machine.setNamemachine(createMachineWrapper.getNamemachine());
        machine.setSerie(createMachineWrapper.getSerie());
        machine.setMachineImage(createMachineWrapper.getImage().getOriginalFilename());
        machine.setDatepurchase(createMachineWrapper.getDatepurchase());
        machine.setEnabled(true);
        return machine;
    }

    public Machine machineModifyWrapper2Machine(Machine machine,MachineModifyWrapper machineModifyWrapper) {
        machine.setFabricator(machineModifyWrapper.getFabricator());
        machine.setModel(machineModifyWrapper.getModel());
        machine.setMark(machineModifyWrapper.getMark());
        machine.setNamemachine(machineModifyWrapper.getNamemachine());
        machine.setSerie(machineModifyWrapper.getSerie());
        machine.setDatepurchase(machineModifyWrapper.getDatepurchase());
        machine.setEnabled(machineModifyWrapper.isEnabled());
        if(machineModifyWrapper.getImage() != null){
            machine.setMachineImage(machineModifyWrapper.getImage().getOriginalFilename());
        }
        return  machine;
    }
}
