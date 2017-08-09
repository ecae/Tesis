package clasem.controllers;

import clasem.api.exceptions.InvalidFieldMachineModifyException;
import clasem.entities.core.Machine;
import clasem.repositories.MachineRepository;
import clasem.services.MachineService;
import clasem.wrappers.machine.CreateMachineWrapper;
import clasem.wrappers.machine.EditMachineWrapper;
import clasem.wrappers.machine.ListMachineWrapper;
import clasem.wrappers.machine.MachineModifyWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MachineController {

    private MachineService machineService;
    private MachineRepository machineRepository;

    @Autowired
    public void setMachineService(MachineService machineService) {
        this.machineService = machineService;
    }

    @Autowired
    public void setMachineRepository(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    public List<ListMachineWrapper> listMachines() {
        return machineService.allMachines();
    }

    public EditMachineWrapper findById(int id) {
        return machineService.findById(id);
    }

    public ResponseEntity saveMachine(CreateMachineWrapper createMachineWrapper) {
        machineService.saveMachine(createMachineWrapper);
        return  new ResponseEntity("Maquinaria creada correctamente", HttpStatus.OK);
    }

    public ResponseEntity updateMachine(int id, MachineModifyWrapper machineModifyWrapper) throws InvalidFieldMachineModifyException {
        Machine machine = machineRepository.findOne(id);
        Machine find = machineRepository.findBySerie(machineModifyWrapper.getSerie());
        if ((find != null) && (machine.getId() != find.getId())) {
            throw new InvalidFieldMachineModifyException("La serie ya esta registrada");
        }else {
            return machineService.updateMachine(machine,machineModifyWrapper);
        }
    }

    public ResponseEntity deleteMachine(int id) {
        machineRepository.delete(id);
        return  new ResponseEntity("Maquinaria eliminada correctamente", HttpStatus.OK);
    }

}
