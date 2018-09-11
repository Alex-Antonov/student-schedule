package my.antonov.study.dao;

import my.antonov.study.model.Tutor;

import java.util.List;

public interface TutorDao {
    List<Tutor> findTutorByName(String name);
    void add(Tutor tutor);
    List<Tutor> findAll();
}
