package clasem.services.impl;

import clasem.converter.MaintenanceConvert;
import clasem.entities.core.Machine;
import clasem.repositories.MachineRepository;
import clasem.repositories.MaintenanceRepository;
import clasem.services.MaintenanceService;
import clasem.wrappers.maintenance.CreateMaintenanceWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private MachineRepository machineRepository;
    private MaintenanceRepository maintenanceRepository;

    @Autowired
    private MaintenanceConvert maintenanceConvert;
    @Autowired
    public void setMachineRepository(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    @Autowired
    public void setMaintenanceRepository(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @Override
    public void createMaintenance(CreateMaintenanceWrapper createMaintenanceWrapper) {
        Machine machine = machineRepository.findById(Integer.parseInt(createMaintenanceWrapper.getId_machine()));
        maintenanceRepository.save(maintenanceConvert.createMaintenanceWrapper2Maintenance(createMaintenanceWrapper,machine));
    }
}
