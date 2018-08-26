package my.antonov.study.model;

import java.util.List;


public class Flow {

    private String specName;
    private List<Group> groups;

    public Flow() {
    }

    public Flow(String specName, List<Group> groups) {
        this.specName = specName;
        this.groups = groups;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
