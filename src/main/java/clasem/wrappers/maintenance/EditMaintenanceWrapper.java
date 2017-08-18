package clasem.wrappers.maintenance;

import clasem.api.URIS;
import clasem.components.constraint.CheckDate;
import clasem.components.constraint.IdConstraint;
import clasem.components.constraint.IntegerConstraint;
import clasem.components.constraint.TypeModality;
import clasem.services.MachineService;
import org.hibernate.validator.constraints.NotEmpty;

public class EditMaintenanceWrapper {

    private String typemodality;
    private String description;
    private String dateinitial;
    private int days;
    private int limithorometer;
    private int id_machine;

    public EditMaintenanceWrapper() {
    }

    public String getTypemodality() {
        return typemodality;
    }

    public void setTypemodality(String typemodality) {
        this.typemodality = typemodality;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateinitial() {
        return dateinitial;
    }

    public void setDateinitial(String dateinitial) {
        this.dateinitial = dateinitial;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getLimithorometer() {
        return limithorometer;
    }

    public void setLimithorometer(int limithorometer) {
        this.limithorometer = limithorometer;
    }

    public int getId_machine() {
        return id_machine;
    }

    public void setId_machine(int id_machine) {
        this.id_machine = id_machine;
    }
}
