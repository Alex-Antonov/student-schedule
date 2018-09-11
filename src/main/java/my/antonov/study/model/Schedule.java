package my.antonov.study.model;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.List;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    private Long id;

    @Column(name = "audience_number")
    private String audienceNumber;

    @Column(name = "day")
    private DayOfWeek dayOfWeek;

    @OneToOne
    @JoinColumn(name = "class_time_id")
    private ClassTime classTime;

    @OneToOne
    @JoinColumn(name = "flow_id")
    private Flow flow;

    @OneToOne
    @JoinColumn(name = "group_id")
    private Groups group;

    @OneToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    public Schedule() {
    }

    public Schedule(String audienceNumber, DayOfWeek dayOfWeek, ClassTime classTime, Flow flow, Groups group, Tutor tutor) {
        this.audienceNumber = audienceNumber;
        this.dayOfWeek = dayOfWeek;
        this.classTime = classTime;
        this.flow = flow;
        this.group = group;
        this.tutor = tutor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAudienceNumber() {
        return audienceNumber;
    }

    public void setAudienceNumber(String audienceNumber) {
        this.audienceNumber = audienceNumber;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public ClassTime getClassTime() {
        return classTime;
    }

    public void setClassTime(ClassTime classTime) {
        this.classTime = classTime;
    }

    public Flow getFlow() {
        return flow;
    }

    public void setFlow(Flow flow) {
        this.flow = flow;
    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
