package my.antonov.study.dao;

import my.antonov.study.model.Subject;

import java.util.List;

public interface SubjectDao {

    List<Subject> findAll();
    List<Subject> findSubjectByName(String name);
    void add(Subject subject);
    List<Subject> findSubjects(List<String> name);
}
