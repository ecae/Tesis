package clasem.services;

import clasem.entities.core.Maintenance;
import clasem.wrappers.maintenance.CreateMaintenanceWrapper;
import clasem.wrappers.maintenance.EditMaintenanceWrapper;
import clasem.wrappers.maintenance.ListMaintenanceWrapper;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MaintenanceService extends FieldValueExists{
    void createMaintenance(CreateMaintenanceWrapper createMaintenanceWrapper);
    List<ListMaintenanceWrapper> allMaintenance();
    EditMaintenanceWrapper findById(int id);
    void updateMaintenance(CreateMaintenanceWrapper createMaintenanceWrapper, Maintenance maintenance);
}
