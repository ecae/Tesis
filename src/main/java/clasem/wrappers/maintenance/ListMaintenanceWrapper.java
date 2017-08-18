package clasem.wrappers.maintenance;

public class ListMaintenanceWrapper {
    private int id;
    private String description;
    private String datemaintenance;
    private int limithorometer;
    private String machine;

    public ListMaintenanceWrapper() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatemaintenance() {
        return datemaintenance;
    }

    public void setDatemaintenance(String datemaintenance) {
        this.datemaintenance = datemaintenance;
    }

    public int getLimithorometer() {
        return limithorometer;
    }

    public void setLimithorometer(int limithorometer) {
        this.limithorometer = limithorometer;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }
}
