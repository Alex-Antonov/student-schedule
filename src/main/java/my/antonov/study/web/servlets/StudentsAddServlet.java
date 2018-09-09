package my.antonov.study.web.servlets;

import my.antonov.study.dao.StudentDao;
import my.antonov.study.dao.impl.StudentDaoIml;
import my.antonov.study.model.Student;
import my.antonov.study.web.ApplicationListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/students/add")
public class StudentsAddServlet extends HttpServlet {
    private StudentDao studentDao = new StudentDaoIml(
            ApplicationListener.getEntityManager()
    );

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/student-add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String type = "STUD";

        System.out.println("isHostelInh:" + req.getParameter("isHostelInh"));
        System.out.println("isGrants:" + req.getParameter("isGrants"));

        boolean isHostelInh = Boolean.parseBoolean(req.getParameter("isHostelInh"));
        boolean isGrants = Boolean.parseBoolean(req.getParameter("isGrants"));

        if (firstName == null) {
            throw new IllegalArgumentException("firstName is missing");
        }
        if (secondName == null) {
            throw new IllegalArgumentException("secondName is missing");
        }
        // ...


        Student student = new Student(firstName, secondName, lastName, phone, email, type, null, null, isHostelInh, isGrants);
        studentDao.add(student);

        resp.sendRedirect("/students/all");
    }
}