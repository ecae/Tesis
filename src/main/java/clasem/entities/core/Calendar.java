package clasem.entities.core;

import clasem.entities.DeletableModel;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Entity
@SQLDelete(sql = "UPDATE calendar SET deleted_at = SYSDATE()  WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted_at IS null")
@Table
public class Calendar extends DeletableModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column()
    private String title;

    @Column
    private Date start;

    @Column
    private Date end;

    @Column
    private String color;

    @Column
    private String description;

    @OneToOne
    @JoinColumn(name = "maintenance_id")
    private Maintenance maintenance;

    public Calendar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Maintenance getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(Maintenance maintenance) {
        this.maintenance = maintenance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Calendar calendar = (Calendar) o;

        return title.equals(calendar.title);
    }

    @Override
    public int hashCode() {
        return id;
    }
}

