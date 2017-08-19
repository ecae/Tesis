package clasem.repositories;

import clasem.entities.core.Calendar;
import clasem.entities.core.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar,Serializable>{
    Calendar findById(int id);
    Calendar findByMaintenance(Maintenance maintenance);
}
