package clasem.entities.core;

import clasem.entities.DeletableModel;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;


@Entity
@SQLDelete(sql = "UPDATE maintenances SET deleted_at = SYSDATE()  WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted_at IS null")
@Table(name = "maintenances")
public class Maintenance extends DeletableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String typemodality;

    @Column(nullable = false)
    private String description;

    @Column
    private Date dateInitial;

    @Column
    private int days;

    @Column
    private Date datemaintenance;

    @Column
    private int limithorometer;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    private Machine machine;

    public Maintenance() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDateInitial() {
        return dateInitial;
    }

    public void setDateInitial(Date dateInitial) {
        this.dateInitial = dateInitial;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Date getDatemaintenance() {
        return datemaintenance;
    }

    public void setDatemaintenance(Date datemaintenance) {
        this.datemaintenance = datemaintenance;
    }

    public int getLimithorometer() {
        return limithorometer;
    }

    public void setLimithorometer(int limithorometer) {
        this.limithorometer = limithorometer;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Maintenance that = (Maintenance) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}

