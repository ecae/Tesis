package clasem.services;

import clasem.entities.user.User;
import clasem.wrappers.AssignmentMachine.DetailsOperatorAssignmentWrapper;

public interface OperatorService {

    DetailsOperatorAssignmentWrapper findDetailAssignment(long id);
}
