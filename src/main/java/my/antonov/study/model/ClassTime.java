package my.antonov.study.model;

import java.sql.Timestamp;

public class ClassTime {

    private Timestamp fromTime;
    private Timestamp toTime;

    public ClassTime() {
    }

    public ClassTime(Timestamp fromTime, Timestamp toTime) {
        this.fromTime = fromTime;
        this.toTime = toTime;
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
