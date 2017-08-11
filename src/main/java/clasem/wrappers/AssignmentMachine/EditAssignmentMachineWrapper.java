package clasem.wrappers.AssignmentMachine;

public class EditAssignmentMachineWrapper {
    private int id;
    private String description;
    private long id_user;
    private int id_machine;

    public EditAssignmentMachineWrapper() {
    }

    public EditAssignmentMachineWrapper(int id, String description, long id_user, int id_machine) {
        this.id = id;
        this.description = description;
        this.id_user = id_user;
        this.id_machine = id_machine;
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

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public int getId_machine() {
        return id_machine;
    }

    public void setId_machine(int id_machine) {
        this.id_machine = id_machine;
    }
}
