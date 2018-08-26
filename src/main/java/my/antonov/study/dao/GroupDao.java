package my.antonov.study.dao;

import my.antonov.study.model.Group;

import java.util.List;

public interface GroupDao {
    List<Group> findGroupByName(String name);
    void add(Group group);
}
