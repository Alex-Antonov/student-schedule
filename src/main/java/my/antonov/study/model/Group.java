package my.antonov.study.model;

import java.time.Year;

public class Group {

    private String name;
    private Flow flow;
    private Year startYear;
    private Year endYear;

    public Group() {
    }

    public Group(String name, Flow flow, Year startYear, Year endYear) {
        this.name = name;
        this.flow = flow;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Flow getFlow() {
        return flow;
    }

    public void setFlow(Flow flow) {
        this.flow = flow;
    }

    public Year getStartYear() {
        return startYear;
    }

    public void setStartYear(Year startYear) {
        this.startYear = startYear;
    }

    public Year getEndYear() {
        return endYear;
    }

    public void setEndYear(Year endYear) {
        this.endYear = endYear;
    }
}
