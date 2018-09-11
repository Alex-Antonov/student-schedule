package my.antonov.study.web.beans;

import my.antonov.study.model.Flow;

import java.util.List;

public class FlowListBean {

    private List<Flow> flows;

    public FlowListBean(List<Flow> flows) {
        this.flows = flows;
    }

    public List<Flow> getFlows() {
        return flows;
    }
}
