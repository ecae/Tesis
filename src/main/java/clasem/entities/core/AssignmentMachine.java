package clasem.entities.core;

import clasem.entities.DeletableModel;
import clasem.entities.user.User;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@SQLDelete(sql = "UPDATE assignment_machine SET deleted_at = SYSDATE()  WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted_at IS null")
@Table
public class AssignmentMachine extends DeletableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String description;

    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "machine_id",nullable = false)
    private Machine machine;

    public AssignmentMachine() {
    }

    public AssignmentMachine(String description, User user, Machine machine) {
        this.description = description;
        this.user = user;
        this.machine = machine;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

        AssignmentMachine that = (AssignmentMachine) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }


}

