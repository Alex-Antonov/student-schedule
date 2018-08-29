package my.antonov.study.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "class_time")
public class ClassTime {

    @Id
    private Long id;

    @Column(name = "from_time")
    private Timestamp fromTime;

    @Column(name = "to_time")
    private Timestamp toTime;

    public ClassTime() {
    }

    public ClassTime(Timestamp fromTime, Timestamp toTime) {
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getFromTime() {
        return fromTime;
    }

    public void setFromTime(Timestamp fromTime) {
        this.fromTime = fromTime;
    }

    public Timestamp getToTime() {
        return toTime;
    }

    public void setToTime(Timestamp toTime) {
        this.toTime = toTime;
    }
}
