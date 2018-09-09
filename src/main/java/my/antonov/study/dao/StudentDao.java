package my.antonov.study.dao;

import my.antonov.study.model.Groups;
import my.antonov.study.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findStudentByName(String name);
    List<Student> findStudentByGroup(Groups group);
    List<Student> findAll();
    void add(Student student);
}
