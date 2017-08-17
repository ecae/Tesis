package clasem.converter;

import clasem.api.URIS;
import clasem.entities.core.Machine;
import clasem.entities.core.Maintenance;
import clasem.wrappers.maintenance.CreateMaintenanceWrapper;
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

                maintenance.setDateInitial(date);
                maintenance.setDays(days);
                maintenance.setDatemaintenance(cal.getTime());
                maintenance.setLimithorometer(0);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else {
            maintenance.setDays(0);
            maintenance.setDateInitial(null);
            maintenance.setLimithorometer(Integer.parseInt(createMaintenanceWrappe.getLimithorometer()));
        }
        return maintenance;
    }

}
