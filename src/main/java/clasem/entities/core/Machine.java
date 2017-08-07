package clasem.entities.core;

import clasem.entities.DeletableModel;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@SQLDelete(sql = "UPDATE machines SET enabled = false, deleted_at = SYSDATE()  WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted_at IS null")
@Table(name = "machines")
public class Machine extends DeletableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    @NotNull
    @Size(min = 3, max = 20)
    private String fabricator;

    @Column(nullable = false)
    @NotNull
    @Size(min = 3, max = 20)
    private String mark;

    @Column(nullable = false)
    @NotNull
    @Size(min = 3, max = 20)
    private String model;

    @Column(nullable = false)
    @NotNull
    @Size(min = 3, max = 20)
    private String namemachine;

    @Column(unique = true, nullable = false)
    @NotNull
    @Size(min = 3, max = 20)
    private String serie;

    @Column(nullable = false)
    @NotNull
    @DateTimeFormat(pattern="YYYY-MM-DD")
    private Date datepurchase;

    @Column(nullable = false)
    @NotNull
    private String machineImage;

    @Column(nullable = false)
    @NotNull
    private boolean enabled;

    public Machine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFabricator() {
        return fabricator;
    }

    public void setFabricator(String fabricator) {
        this.fabricator = fabricator;
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

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Date getDatepurchase() {
        return datepurchase;
    }

    public void setDatepurchase(Date datepurchase) {
        this.datepurchase = datepurchase;
    }

    public String getMachineImage() {
        return machineImage;
    }

    public void setMachineImage(String machineImage) {
        this.machineImage = machineImage;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Machine machine = (Machine) o;

        return serie.equals(machine.serie);
    }

    @Override
    public int hashCode() {
        return id;
    }
}

