package my.antonov.study.web.servlets;

import my.antonov.study.dao.FlowDao;
import my.antonov.study.model.Flow;
import my.antonov.study.web.beans.FlowListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@Controller
public class FlowListController {

    @Autowired
    private FlowDao flowDao;

    @RequestMapping(method = RequestMethod.GET, value = "/flow/all")
    public String getFlowList(ModelMap model) throws ServletException, IOException {
        List<Flow> flows = flowDao.findAll();

        FlowListBean bean = new FlowListBean(flows);

        model.put("flowBean", bean);

        return "flow-list";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/flow/add")
    public String addFlowShowForm() {
        return "flow-add";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/flow/add")
    public String addNewFlow(@RequestParam("specName") String specName,
                                ModelMap model) throws ServletException, IOException {

        if (specName == null) {
            throw new IllegalArgumentException("specName is missing");
        }

        Flow flow = new Flow(specName, null);
        flowDao.add(flow);

        return getFlowList(model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/group/add")
    public String addGroupShowForm(ModelMap model) {
        List<Flow> flows = flowDao.findAll();

        FlowListBean bean = new FlowListBean(flows);

        model.put("flowBean", bean);

        return "group-add";
    }
}
