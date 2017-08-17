package clasem.controllers;

import clasem.services.MaintenanceService;
import clasem.wrappers.maintenance.CreateMaintenanceWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class MaintenanceController {

    private MaintenanceService  maintenanceService;

    @Autowired
    public void setMaintenanceService(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    public ResponseEntity createMaintenance(CreateMaintenanceWrapper maintenanceWrapper) {
        if(maintenanceWrapper.getTypemodality().equals("DAYS")){

        }
        maintenanceService.createMaintenance(maintenanceWrapper);
        return new ResponseEntity("Se ha creado el Mantenimiento correctamente", HttpStatus.OK);
    }
}
