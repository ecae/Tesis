package clasem.services.impl;

import clasem.converter.AssignmentMachineConvert;
import clasem.entities.core.AssignmentMachine;
import clasem.entities.user.User;
import clasem.repositories.AssignmentMachineRepository;
import clasem.repositories.UserRepository;
import clasem.services.OperatorService;
import clasem.wrappers.AssignmentMachine.DetailsOperatorAssignmentWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperatorServiceImpl implements OperatorService {

    private AssignmentMachineRepository assignmentMachineRepository;
    private UserRepository userRepository;

    @Autowired
    private AssignmentMachineConvert assignmentMachineConvert;

    @Autowired
    public void setAssignmentMachineRepository(AssignmentMachineRepository assignmentMachineRepository) {
        this.assignmentMachineRepository = assignmentMachineRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public DetailsOperatorAssignmentWrapper findDetailAssignment(long id) {
        User user = userRepository.findById(id);
        AssignmentMachine assignmentMachine = assignmentMachineRepository.findByUser(user);
        return assignmentMachineConvert.assignment2detailOperatorAuthenticated(assignmentMachine);
    }
}
