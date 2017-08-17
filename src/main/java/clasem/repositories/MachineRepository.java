package clasem.repositories;

import clasem.entities.core.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Integer> {

    Machine findById(int id);
    Machine findBySerie(String serie);
}
