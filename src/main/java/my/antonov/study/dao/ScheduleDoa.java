package my.antonov.study.dao;

import my.antonov.study.model.Groups;
import my.antonov.study.model.Schedule;

import java.util.List;

public interface ScheduleDoa {
    List<ScheduleDoa> findScheduleByGroup(Groups group);
    void add(Schedule schedule);
}
