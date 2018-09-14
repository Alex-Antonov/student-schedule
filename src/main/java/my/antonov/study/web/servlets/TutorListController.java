package my.antonov.study.web.servlets;

import com.google.common.collect.Lists;
import my.antonov.study.dao.SubjectDao;
import my.antonov.study.dao.TutorDao;
import my.antonov.study.model.Subject;
import my.antonov.study.model.Tutor;
import my.antonov.study.web.beans.SubjectListBean;
import my.antonov.study.web.beans.TutorListBean;
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
public class TutorListController {

    @Autowired
    private TutorDao tutorDao;

    @Autowired
    private SubjectDao subjectDao;

    @RequestMapping(method = RequestMethod.GET, value = "/tutor/all")
    public String getStudentList(ModelMap model) throws ServletException, IOException {
        List<Tutor> tutors = tutorDao.findAll();

        TutorListBean bean = new TutorListBean(tutors);

        model.put("tutorBean", bean);

        return "tutor-list";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tutor/add")
    public String addStudentShowForm(ModelMap model) {
        List<Subject> subjects = subjectDao.findAll();

        SubjectListBean bean = new SubjectListBean(subjects);

        model.put("subjBean", bean);

        return "tutor-add";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/tutor/add")
    public String addNewStudent(@RequestParam("firstName") String firstName,
                                @RequestParam("secondName") String secondName,
                                @RequestParam(value = "lastName", required = false) String lastName,
                                @RequestParam("email") String email,
                                @RequestParam("phone") String phone,
                                @RequestParam("degree") String degree,
                                @RequestParam("experience") Integer experience,
                                @RequestParam(value = "subjects", required = false) String[] subjects,
                                ModelMap model) throws ServletException, IOException {
        String type = "TUTOR";

        List<Subject> subjectList = null;

        if (firstName == null) {
            throw new IllegalArgumentException("firstName is missing");
        }
        if (secondName == null) {
            throw new IllegalArgumentException("secondName is missing");
        }
        if (email == null) {
            throw new IllegalArgumentException("email is missing");
        }
        if (phone == null) {
            throw new IllegalArgumentException("phone is missing");
        }
        if (degree == null) {
            throw new IllegalArgumentException("degree is missing");
        }
        if (experience == null) {
            throw new IllegalArgumentException("experience is missing");
        }
        if(subjects != null) {
            subjectList = subjectDao.findSubjects(Lists.newArrayList(subjects));
        }

        Tutor tutor = new Tutor(firstName, secondName, lastName, phone, email, type, null, subjectList, degree, experience);

        tutorDao.add(tutor);

        return getStudentList(model);
    }
}
