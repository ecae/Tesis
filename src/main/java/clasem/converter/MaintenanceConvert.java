package clasem.converter;

import clasem.api.URIS;
import clasem.entities.core.Machine;
import clasem.entities.core.Maintenance;
import clasem.wrappers.maintenance.CreateMaintenanceWrapper;
import clasem.wrappers.maintenance.EditMaintenanceWrapper;
import clasem.wrappers.maintenance.ListMaintenanceWrapper;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class MaintenanceConvert {

    public Maintenance createMaintenanceWrapper2Maintenance(CreateMaintenanceWrapper createMaintenanceWrappe, Machine machine) {
        Maintenance maintenance = new Maintenance();
        maintenance.setDescription(createMaintenanceWrappe.getDescription());
        maintenance.setTypemodality(createMaintenanceWrappe.getTypemodality());
        maintenance.setMachine(machine);
        if(createMaintenanceWrappe.getTypemodality().equals("DAYS")){
            try {
                Date date= new SimpleDateFormat(URIS.DATEFORMAT).parse(createMaintenanceWrappe.getDateinitial());
                int days = Integer.parseInt(createMaintenanceWrappe.getDays());
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.DATE,days);

                maintenance.setDateinitial(date);
                maintenance.setDays(days);
                maintenance.setDatemaintenance(cal.getTime());
                maintenance.setLimithorometer(0);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else {
            maintenance.setDays(0);
            maintenance.setDateinitial(null);
            maintenance.setLimithorometer(Integer.parseInt(createMaintenanceWrappe.getLimithorometer()));
        }
        return maintenance;
    }

    public ListMaintenanceWrapper maintenance2ListMaintenanceWrapper(Maintenance maintenance) {
        ListMaintenanceWrapper listMaintenanceWrapper =  new ListMaintenanceWrapper();
        listMaintenanceWrapper.setId(maintenance.getId());
        listMaintenanceWrapper.setDescription(maintenance.getDescription());
        listMaintenanceWrapper.setDatemaintenance(setterDate(maintenance.getDatemaintenance()));
        listMaintenanceWrapper.setLimithorometer(maintenance.getLimithorometer());
        listMaintenanceWrapper.setMachine(maintenance.getMachine().getNamemachine());
        return listMaintenanceWrapper;
    }

    public EditMaintenanceWrapper maintenance2EditMaintenanceWrapper(Maintenance maintenance) {
        EditMaintenanceWrapper editMaintenanceWrapper = new EditMaintenanceWrapper();
        editMaintenanceWrapper.setTypemodality(maintenance.getTypemodality());
        editMaintenanceWrapper.setDescription(maintenance.getDescription());
        editMaintenanceWrapper.setDateinitial(setterDate(maintenance.getDateinitial()));
        editMaintenanceWrapper.setLimithorometer(maintenance.getLimithorometer());
        editMaintenanceWrapper.setDays(maintenance.getDays());
        editMaintenanceWrapper.setId_machine(maintenance.getId());
        return editMaintenanceWrapper;
    }

    public Maintenance updateMaintenance2Maintenance(CreateMaintenanceWrapper createMaintenanceWrapper,Machine machine, Maintenance maintenance){
        Maintenance maintenance1 = createMaintenanceWrapper2Maintenance(createMaintenanceWrapper,machine);
        maintenance1.setId(maintenance.getId());
        maintenance1.setCreatedAt(maintenance.getCreatedAt());
        maintenance1.setUpdatedAt(maintenance.getUpdatedAt());
        maintenance1.setDeletedAt(maintenance.getDeletedAt());
        return maintenance1;
    }

    public String setterDate(Date date) {
        if(date == null){
            return "";
        }
        return date.toString();
    }

}
