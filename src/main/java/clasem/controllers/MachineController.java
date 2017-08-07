package clasem.controllers;

import clasem.api.exceptions.InvalidImageException;
import clasem.services.MachineService;
import clasem.wrappers.machine.CreateMachineWrapper;
import clasem.wrappers.machine.EditMachineWrapper;
import clasem.wrappers.machine.ListMachineWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class MachineController {

    private MachineService machineService;

    @Autowired
    public void setMachineService(MachineService machineService) {
        this.machineService = machineService;
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

}
