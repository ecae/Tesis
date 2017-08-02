package clasem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.DateTime;

import javax.annotation.PreDestroy;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import java.sql.Timestamp;

@MappedSuperclass
public abstract class DeletableModel extends DatedModel {

    @Column( name = "deleted_at" )
    private Timestamp deletedAt;

    public DeletableModel() {
    }

    @JsonIgnore
    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt( Timestamp deletedAt ) {
        this.deletedAt = deletedAt;
    }

    @JsonIgnore
    public boolean isDeleted() {
        return getDeletedAt() != null;
    }

    @PreRemove
    public void onPreRemove() {
        Timestamp now = new Timestamp(new DateTime().getMillis());
        setDeletedAt(now);
    }

}

