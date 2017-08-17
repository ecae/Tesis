package clasem.repositories;

import clasem.entities.core.Machine;
import clasem.entities.core.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance,Serializable> {

    Maintenance findById(int id);
    Maintenance findByMachine(Machine machine);
}
