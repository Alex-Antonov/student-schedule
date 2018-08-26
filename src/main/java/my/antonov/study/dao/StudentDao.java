package my.antonov.study.dao;

import my.antonov.study.model.Group;
import my.antonov.study.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findStudentByName(String name);
    List<Student> findStudentByGroup(Group group);
    void add(Student student);
}
