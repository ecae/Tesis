package clasem.repositories;

import clasem.entities.core.AssignmentMachine;
import clasem.entities.core.Machine;
import clasem.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface AssignmentMachineRepository extends JpaRepository<AssignmentMachine, Serializable> {

    AssignmentMachine findById(int id);
    AssignmentMachine findByUser(User user);
    AssignmentMachine findByMachine(Machine machine);
}
