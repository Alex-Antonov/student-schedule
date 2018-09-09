package my.antonov.study.dao;

import my.antonov.study.model.Person;

import java.util.List;

public interface PersonDao {

    Person findPersonByName(String name);

    void add(Person person);
}
