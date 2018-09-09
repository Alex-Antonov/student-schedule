package my.antonov.study.web.servlets;



import my.antonov.study.dao.StudentDao;
import my.antonov.study.dao.impl.StudentDaoIml;
import my.antonov.study.model.Groups;
import my.antonov.study.model.Student;
import my.antonov.study.web.ApplicationListener;
import my.antonov.study.web.beans.StudentListBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/students/all" })
public class StudentsListServlet extends HttpServlet {

    private StudentDao dao = new StudentDaoIml(ApplicationListener.getEntityManager());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Student> students = dao.findAll();

        StudentListBean bean = new StudentListBean(students);

        req.setAttribute("bean", bean);

        req.getRequestDispatcher("/pages/student-list.jsp")
                .forward(req, resp);
    }
}
