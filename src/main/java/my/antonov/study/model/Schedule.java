package my.antonov.study.model;

import java.time.DayOfWeek;
import java.util.List;

public class Schedule {

    private String audienceNumber;
    private DayOfWeek dayOfWeek;
    private ClassTime classTime;
    private List<Flow> flow;
    private Group group;
    private Tutor tutor;

    public Schedule() {
    }

    public Schedule(String audienceNumber, DayOfWeek dayOfWeek, ClassTime classTime, List<Flow> flow, Group group, Tutor tutor) {
        this.audienceNumber = audienceNumber;
        this.dayOfWeek = dayOfWeek;
        this.classTime = classTime;
        this.flow = flow;
        this.group = group;
        this.tutor = tutor;
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

    public List<Flow> getFlow() {
        return flow;
    }

    public void setFlow(List<Flow> flow) {
        this.flow = flow;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
