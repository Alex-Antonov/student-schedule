package my.antonov.study.dao;

import my.antonov.study.model.Groups;

import java.util.List;

public interface GroupDao {
    List<Groups> findGroupByName(String name);
    void add(Groups group);
}
