package clasem.controllers;

import clasem.entities.core.Maintenance;
import clasem.repositories.MaintenanceRepository;
import clasem.services.CalendarService;
import clasem.services.MaintenanceService;
import clasem.wrappers.maintenance.CreateMaintenanceWrapper;
import clasem.wrappers.maintenance.EditMaintenanceWrapper;
import clasem.wrappers.maintenance.ListMaintenanceWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MaintenanceController {

    private MaintenanceService  maintenanceService;
    private MaintenanceRepository maintenanceRepository;
    private CalendarService calendarService;

    @Autowired
    public void setMaintenanceService(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @Autowired
    public void setMaintenanceRepository(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @Autowired
    public void setCalendarService(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    public ResponseEntity createMaintenance(CreateMaintenanceWrapper maintenanceWrapper) {
        maintenanceService.createMaintenance(maintenanceWrapper);
        return new ResponseEntity("Se ha creado el Mantenimiento correctamente", HttpStatus.OK);
    }

    public List<ListMaintenanceWrapper> listAll() {
        return maintenanceService.allMaintenance();
    }

    public EditMaintenanceWrapper findMainteanceById(String id){
        return maintenanceService.findById(Integer.parseInt(id));
    }

    public ResponseEntity updateMaintenance(String id,CreateMaintenanceWrapper createMaintenanceWrapper){
        Maintenance maintenance = maintenanceRepository.findById(Integer.parseInt(id));
        maintenanceService.updateMaintenance(createMaintenanceWrapper,maintenance);
        return new ResponseEntity("Se ha actualizado el Mantenimiento correctamente", HttpStatus.OK);
    }

    public ResponseEntity deleteMaintenance(String id) {
        int nid = Integer.parseInt(id);
        calendarService.deleteCalendar(nid);
        maintenanceRepository.delete(nid);
        return new ResponseEntity("Se ha eliminado el Mantenimiento correctamente", HttpStatus.OK);
    }
}
