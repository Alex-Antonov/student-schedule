package my.antonov.study.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "class_time")
public class ClassTime {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flow_seq_gen")
    @SequenceGenerator(name = "flow_seq_gen", sequenceName = "flow_id_seq", allocationSize = 1)
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
