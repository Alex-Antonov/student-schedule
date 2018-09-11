package my.antonov.study.dao;

import my.antonov.study.model.Flow;

import java.util.List;

public interface FlowDao {
    List<Flow> findAll();
    List<Flow> findFlowByName(String name);
    void add(Flow flow);
}
