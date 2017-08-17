package clasem.wrappers.maintenance;

import clasem.api.URIS;
import clasem.components.constraint.*;
import clasem.services.MachineService;
import org.hibernate.validator.constraints.NotEmpty;

@FieldMatch.List({
        @FieldMatch(first = "typemodality", second = "limithorometer", help = "horometer", errorMessage = "Ingrese un límite para el horometro"),
        @FieldMatch(first = "typemodality", second = "days",help = "days", errorMessage = "Ingrese un número de días"),
        @FieldMatch(first = "typemodality", second = "dateinitial",help = "dateinitial", errorMessage = "Ingrese la fecha de inicio")
})
public class CreateMaintenanceWrapper {

    @TypeModality
    private String typemodality;

    @NotEmpty
    private String description;

    @CheckDate(pattern = URIS.DATEFORMAT)
    private String dateinitial;

    @IntegerConstraint(message = "El número de días no es inválido")
    private String days;

    @IntegerConstraint(message = "Ingrese un Horómetro válido")
    private String limithorometer;

    @IdConstraint(service = MachineService.class)
    private String id_machine;

    public CreateMaintenanceWrapper() {
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

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getLimithorometer() {
        return limithorometer;
    }

    public void setLimithorometer(String limithorometer) {
        this.limithorometer = limithorometer;
    }

    public String getId_machine() {
        return id_machine;
    }

    public void setId_machine(String id_machine) {
        this.id_machine = id_machine;
    }

    @Override
    public String toString() {
        return "CreateMaintenanceWrapper{" +
                "typemodality='" + typemodality + '\'' +
                ", description='" + description + '\'' +
                ", dateInitial=" + dateinitial +
                ", days=" + days +
                ", limithorometer=" + limithorometer +
                ", id_machine='" + id_machine + '\'' +
                '}';
    }
}
