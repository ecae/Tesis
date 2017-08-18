package clasem.services.impl;

import clasem.converter.MaintenanceConvert;
import clasem.entities.core.Machine;
import clasem.entities.core.Maintenance;
import clasem.repositories.MachineRepository;
import clasem.repositories.MaintenanceRepository;
import clasem.services.MaintenanceService;
import clasem.wrappers.maintenance.CreateMaintenanceWrapper;
import clasem.wrappers.maintenance.EditMaintenanceWrapper;
import clasem.wrappers.maintenance.ListMaintenanceWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<ListMaintenanceWrapper> allMaintenance() {
        List<Maintenance> maintenanceList = maintenanceRepository.findAll();
        List<ListMaintenanceWrapper> listMaintenanceWrappers = new ArrayList<ListMaintenanceWrapper>();
        for(Maintenance maintenance:maintenanceList){
            listMaintenanceWrappers.add(maintenanceConvert.maintenance2ListMaintenanceWrapper(maintenance));
        }
        return listMaintenanceWrappers;
    }

    @Override
    public EditMaintenanceWrapper findById(int id) {
        return maintenanceConvert.maintenance2EditMaintenanceWrapper(maintenanceRepository.findById(id));
    }

    @Override
    public void updateMaintenance(CreateMaintenanceWrapper createMaintenanceWrapper, Maintenance maintenance) {
        Machine machine = machineRepository.findById(Integer.parseInt(createMaintenanceWrapper.getId_machine()));
        maintenanceRepository.save(maintenanceConvert.updateMaintenance2Maintenance(createMaintenanceWrapper,machine,maintenance));
    }

    @Override
    public boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException {
        return false;
    }

    @Override
    public boolean fieldIdExists(String id) throws UnsupportedOperationException {

        if (id == null  || id == "") {
            return false;
        }
        int nid = Integer.parseInt(id);
        Maintenance maintenance = maintenanceRepository.findOne(nid);
        return verifyNullMaintenance(maintenance);
    }

    private boolean verifyNullMaintenance(Maintenance maintenance) {
        if (null != maintenance) {
            return false;
        }
        return true;
    }
}
