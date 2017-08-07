package clasem.wrappers.machine;

public class ListMachineWrapper {

    private int id;
    private String mark;
    private String model;
    private String namemachine;

    public ListMachineWrapper() {
    }

    public ListMachineWrapper(int id, String mark, String model, String namemachine) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.namemachine = namemachine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNamemachine() {
        return namemachine;
    }

    public void setNamemachine(String namemachine) {
        this.namemachine = namemachine;
    }

    @Override
    public String toString() {
        return "ListMachineWrapper{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", name machine='" + namemachine + '\'' +
                '}';
    }
}
