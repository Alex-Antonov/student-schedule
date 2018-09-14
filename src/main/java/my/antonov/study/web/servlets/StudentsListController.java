package my.antonov.study.web.servlets;

import my.antonov.study.dao.GroupDao;
import my.antonov.study.dao.StudentDao;
import my.antonov.study.model.Groups;
import my.antonov.study.model.Student;
import my.antonov.study.web.beans.GroupListBean;
import my.antonov.study.web.beans.StudentListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@Controller
public class StudentsListController {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private GroupDao groupDao;

    @RequestMapping(method = RequestMethod.GET, value = "/students/all")
    public String getStudentList(ModelMap model) throws ServletException, IOException {
        List<Student> students = studentDao.findAll();

        StudentListBean bean = new StudentListBean(students);

        model.put("studBean", bean);

        return "student-list";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/students/add")
    public String addStudentShowForm(ModelMap model) {
        List<Groups> groups = groupDao.findAll();

        GroupListBean bean = new GroupListBean(groups);

        model.put("groupBean", bean);

        return "student-add";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/students/add")
    public String addNewStudent(@RequestParam("firstName") String firstName,
                                @RequestParam("secondName") String secondName,
                                @RequestParam(value = "lastName", required = false) String lastName,
                                @RequestParam("email") String email,
                                @RequestParam("phone") String phone,
                                @RequestParam(value = "isHostelInh", required = false) String isHostelInh,
                                @RequestParam(value = "isGrants", required = false) String isGrants,
                                @RequestParam(value = "groupName", required = false) String groupName,
                                ModelMap model) throws ServletException, IOException {
        String type = "STUD";
        Groups group = null;
        boolean isHostelInhBool = Boolean.parseBoolean(isHostelInh);
        boolean isGrantsBool = Boolean.parseBoolean(isGrants);

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


        List<Groups> groups = groupDao.findGroupByName(groupName);

        if(!CollectionUtils.isEmpty(groups)) {
            group = groups.get(0);
        }

        Student student = new Student(firstName, secondName, lastName, phone, email, type, null, group, isHostelInhBool, isGrantsBool);
        studentDao.add(student);

        return getStudentList(model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/students/{id}")
    public String showStudent(@PathVariable("id") Long id, ModelMap model) {

        Student student = studentDao.findById(id);

        model.put("stud", student);
        return "student-show";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/students/edit/{id}")
    public String editStudent(@PathVariable("id") Long id, ModelMap model) {

        showStudent(id, model);
        addStudentShowForm(model);
        return "student-edit";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/students/update/{id}")
    public String addNewStudent(@PathVariable("id") Long id,
                                @RequestParam("firstName") String firstName,
                                @RequestParam("secondName") String secondName,
                                @RequestParam(value = "lastName", required = false) String lastName,
                                @RequestParam("email") String email,
                                @RequestParam("phone") String phone,
                                @RequestParam(value = "isHostelInh", required = false) String isHostelInh,
                                @RequestParam(value = "isGrants", required = false) String isGrants,
                                @RequestParam(value = "groupName", required = false) String groupName,
                                ModelMap model) throws ServletException, IOException {
        String type = "STUD";
        Groups group = null;
        boolean isHostelInhBool = Boolean.parseBoolean(isHostelInh);
        boolean isGrantsBool = Boolean.parseBoolean(isGrants);

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

        List<Groups> groups = groupDao.findGroupByName(groupName);

        if(!CollectionUtils.isEmpty(groups)) {
            group = groups.get(0);
        }

        Student student = new Student(firstName, secondName, lastName, phone, email, type, null, group, isHostelInhBool, isGrantsBool);
        student.setId(id);
        studentDao.update(student);

        return getStudentList(model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/students/delete/{id}")
    public String addNewStudent(@PathVariable("id") Long id, ModelMap model) throws ServletException, IOException {

        studentDao.delete(id);

        return getStudentList(model);
    }
}
