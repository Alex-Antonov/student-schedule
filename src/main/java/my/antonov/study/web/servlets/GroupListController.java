package my.antonov.study.web.servlets;

import my.antonov.study.dao.FlowDao;
import my.antonov.study.dao.GroupDao;
import my.antonov.study.model.Flow;
import my.antonov.study.model.Groups;
import my.antonov.study.web.beans.GroupListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@Controller
public class GroupListController {

    @Autowired
    private GroupDao groupDao;
    @Autowired
    private FlowDao flowDao;

    @RequestMapping(method = RequestMethod.GET, value = "/group/all")
    public String getGroupList(ModelMap model) throws ServletException, IOException {
        List<Groups> groups = groupDao.findAll();

        GroupListBean bean = new GroupListBean(groups);

        model.put("groupBean", bean);

        return "group-list";
    }



    @RequestMapping(method = RequestMethod.POST, path = "/group/add")
    public String addNewGroup(@RequestParam("name") String name,
                              @RequestParam("startYear") Integer startYear,
                              @RequestParam("endYear") Integer endYear,
                              @RequestParam(value = "flowSpecName", required = false) String flowSpecName,
                                ModelMap model) throws ServletException, IOException {

        System.out.println("flowSpecName: " + flowSpecName);
        List<Flow> flow = flowDao.findFlowByName(flowSpecName);

        if (name == null) {
            throw new IllegalArgumentException("name is missing");
        }

        if(CollectionUtils.isEmpty(flow)) {
            throw new IllegalArgumentException("group is missing");
        }

        Groups group = new Groups(name, flow.get(0), startYear, endYear);
        flow.get(0).getGroups().add(group);
        groupDao.add(group);

        return getGroupList(model);
    }
}
