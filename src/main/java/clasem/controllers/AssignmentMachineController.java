package clasem.controllers;

import clasem.api.exceptions.InvalidFieldModifyAssignmentMachineException;
import clasem.entities.core.AssignmentMachine;
import clasem.entities.core.Machine;
import clasem.entities.user.User;
import clasem.repositories.AssignmentMachineRepository;
import clasem.repositories.MachineRepository;
import clasem.repositories.UserRepository;
import clasem.services.AssignmentMachineService;
import clasem.wrappers.AssignmentMachine.CreateAssignmentMachineWrapper;
import clasem.wrappers.AssignmentMachine.EditAssignmentMachineWrapper;
import clasem.wrappers.AssignmentMachine.ListAssignmentMachineWrapper;
import clasem.wrappers.AssignmentMachine.UpdateAssignmentMachineWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AssignmentMachineController {

    private AssignmentMachineService assignmentMachineService;
    private AssignmentMachineRepository assignmentMachineRepository;
    private UserRepository userRepository;
    private MachineRepository machineRepository;

    @Autowired
    public void setAssignmentMachineService(AssignmentMachineService assignmentMachineService){
        this.assignmentMachineService = assignmentMachineService;
    }

    @Autowired
    public void setAssignmentMachineRepository(AssignmentMachineRepository assignmentMachineRepository) {
        this.assignmentMachineRepository = assignmentMachineRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setMachineRepository(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    public ResponseEntity createAssignmentMachine(CreateAssignmentMachineWrapper createAssignmentMachineWrapper) {

        String description = createAssignmentMachineWrapper.getDescription();
        long id_user = Long.parseLong(createAssignmentMachineWrapper.getId_user());
        int id_machine = Integer.parseInt(createAssignmentMachineWrapper.getId_machine());
        assignmentMachineService.createAssignment(description,id_user,id_machine);
        return new ResponseEntity("Se asignó la maquinaria correctamente",HttpStatus.OK);
    }

    public List<ListAssignmentMachineWrapper> listAssignments() {
        return assignmentMachineService.listAssignments();
    }

    public EditAssignmentMachineWrapper findById(String id) {
        int nid = Integer.parseInt(id);
        return assignmentMachineService.findById(nid);
    }

    public ResponseEntity UpdateAssignment(String id, UpdateAssignmentMachineWrapper updateAssignment) throws InvalidFieldModifyAssignmentMachineException {

        AssignmentMachine assignmentMachine = assignmentMachineRepository.findOne(Integer.parseInt(id));
        User user = userRepository.findById(Long.parseLong(updateAssignment.getId_user()));
        AssignmentMachine F2User = assignmentMachineRepository.findByUser(user);
        Machine machine = machineRepository.findById(Integer.parseInt(updateAssignment.getId_machine()));
        AssignmentMachine F2Machine = assignmentMachineRepository.findByMachine(machine);
        if((F2User != null) && (assignmentMachine.getId() != F2User.getId())) {
            throw new InvalidFieldModifyAssignmentMachineException("Usuario ya esta registrado");
        }else if((F2Machine != null) && (assignmentMachine.getId() != F2Machine.getId()) ) {
            throw new InvalidFieldModifyAssignmentMachineException("Maquinaria ya esta registrado");
        }else {
            return assignmentMachineService.updateAssignment(assignmentMachine, updateAssignment.getDescription(), user, machine);
        }
    }

    public ResponseEntity deleteAssignment(String id) {
        int nid = Integer.parseInt(id);
        assignmentMachineRepository.delete(nid);
        return new ResponseEntity("Se ha eliminado la Asignación",HttpStatus.OK);
    }
}
