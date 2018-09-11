package my.antonov.study.web.beans;

import my.antonov.study.model.Groups;

import java.util.List;

public class GroupListBean {

    private List<Groups> groups;

    public GroupListBean(List<Groups> groups) {
        this.groups = groups;
    }

    public List<Groups> getGroups() {
        return groups;
    }
}
