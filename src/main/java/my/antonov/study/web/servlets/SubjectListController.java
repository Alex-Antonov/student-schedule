package my.antonov.study.web.servlets;

import my.antonov.study.dao.SubjectDao;
import my.antonov.study.model.Subject;
import my.antonov.study.web.beans.SubjectListBean;
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
public class SubjectListController {

    @Autowired
    private SubjectDao subjectDao;

    @RequestMapping(method = RequestMethod.GET, value = "/subject/all")
    public String getSubjectList(ModelMap model) throws ServletException, IOException {
        List<Subject> subjects = subjectDao.findAll();

        SubjectListBean bean = new SubjectListBean(subjects);

        model.put("subjBean", bean);

        return "subject-list";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/subject/add")
    public String addSubjectShowForm() {
        return "subject-add";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/subject/add")
    public String addNewSubject(@RequestParam("subjName") String subjName,
                             ModelMap model) throws ServletException, IOException {

        if (subjName == null) {
            throw new IllegalArgumentException("subjName is missing");
        }

        Subject Subject = new Subject(subjName);
        subjectDao.add(Subject);

        return getSubjectList(model);
    }
}
