package my.antonov.study.dao;

import my.antonov.study.model.Group;
import my.antonov.study.model.Schedule;

import java.util.List;

public interface ScheduleDoa {
    List<ScheduleDoa> findScheduleByGroup(Group group);
    void add(Schedule schedule);
}
