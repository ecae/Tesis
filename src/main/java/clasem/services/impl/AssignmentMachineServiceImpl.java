package clasem.services.impl;

import clasem.converter.AssignmentMachineConvert;
import clasem.entities.core.AssignmentMachine;
import clasem.entities.core.Machine;
import clasem.entities.user.User;
import clasem.repositories.AssignmentMachineRepository;
import clasem.repositories.MachineRepository;
import clasem.repositories.UserRepository;
import clasem.services.AssignmentMachineService;
import clasem.wrappers.AssignmentMachine.EditAssignmentMachineWrapper;
import clasem.wrappers.AssignmentMachine.ListAssignmentMachineWrapper;
import clasem.wrappers.AssignmentMachine.UpdateAssignmentMachineWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssignmentMachineServiceImpl implements AssignmentMachineService {

    private AssignmentMachineRepository assignmentMachineRepository;
    private UserRepository userRepository;
    private MachineRepository machineRepository;

    @Autowired
    private AssignmentMachineConvert assignmentMachineConvert;

    @Autowired
    public void setAssignmentMachineRepository(AssignmentMachineRepository assignmentMachineRepository){
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

    @Override
    public void createAssignment(String description, long id_user, int id_machine) {
        User user = userRepository.findById(id_user);
        Machine machine = machineRepository.findById(id_machine);
        assignmentMachineRepository.save(assignmentMachineConvert.assignmentMachine(description, user, machine));
    }

    @Override
    public List<ListAssignmentMachineWrapper> listAssignments() {
        List<AssignmentMachine> assignmentMachines = assignmentMachineRepository.findAll();
        List<ListAssignmentMachineWrapper> listAssignmentMachineWrappers = new ArrayList<ListAssignmentMachineWrapper>();

        for (AssignmentMachine assignmentMachine: assignmentMachines) {
            listAssignmentMachineWrappers.add(assignmentMachineConvert.AssignmentMachine2ListAssignmentMachineWrapper(assignmentMachine));
        }
        return listAssignmentMachineWrappers;
    }

    @Override
    public EditAssignmentMachineWrapper findById(int id) {
        return assignmentMachineConvert.assignmentMachine2EEditAssignmentMachineWrapper(assignmentMachineRepository.findById(id));
    }

    @Override
    public ResponseEntity updateAssignment(AssignmentMachine assignmentMachine, String description, User user, Machine machine) {
        this.assignmentMachineRepository.save(assignmentMachineConvert.UpdateAssigment2AssginmentMachine(assignmentMachine,description,user,machine));
        return new ResponseEntity("Asignacion de la Maquinaria ha sido actualizada", HttpStatus.OK);
    }

    @Override
    public boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException {
        Assert.notNull(fieldName);

        if (!fieldName.equals("id_user") && !fieldName.equals("id_machine")) {
            throw new UnsupportedOperationException("Field name not supported");
        }

        if (value == null || value == "") {
            return false;
        }

        AssignmentMachine assignmentMachine = switchUnique(fieldName,value);

        return verifyNullAssingment(assignmentMachine);
    }

    @Override
    public boolean fieldIdExists(String id) throws UnsupportedOperationException {
        if (id == null || id.equals("")) {
            return false;
        }
        int nid = Integer.parseInt(id);
        AssignmentMachine assignmentMachine = assignmentMachineRepository.findById(nid);

        if (null != assignmentMachine) {
            return false;
        }
        return true;
    }

    public AssignmentMachine switchUnique(String f, Object value) {
        AssignmentMachine assignmentMachine = null;

        switch (f) {
            case "" : return null;
            case "id_user" :
                User user = userRepository.findById(Long.parseLong(value.toString()));
                assignmentMachine= assignmentMachineRepository.findByUser(user);
                break;
            case "id_machine" :
                Machine machine = machineRepository.findById(Integer.parseInt(value.toString()));
                assignmentMachine =  assignmentMachineRepository.findByMachine(machine);
                break;
        }
        return assignmentMachine;
    }

    public boolean verifyNullAssingment(AssignmentMachine assignmentMachine){
        if (null == assignmentMachine) {
            return false;
        }
        return true;
    }
}
