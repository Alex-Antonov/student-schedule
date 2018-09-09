package my.antonov.study.web.beans;

import my.antonov.study.model.Student;

import java.util.List;

public class StudentListBean {

    private List<Student> students;

    public StudentListBean(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }
}
