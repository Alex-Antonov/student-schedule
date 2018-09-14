package my.antonov.study.dao;

import my.antonov.study.model.Groups;
import my.antonov.study.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentDao {
    Student findById(Long id);
    List<Student> findStudentByName(String name);
    List<Student> findStudentByGroup(Groups group);
    List<Student> findAll();
    void add(Student student);
    void update(Student student);
    void delete(Long id);
}
