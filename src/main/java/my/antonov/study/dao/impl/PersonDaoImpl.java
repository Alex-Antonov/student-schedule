package my.antonov.study.dao.impl;

import my.antonov.study.dao.PersonDao;
import my.antonov.study.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class PersonDaoImpl implements PersonDao {

    private EntityManager em;

    @Autowired
    public PersonDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Person findPersonByName(String name) {
        return null;// em.createNamedQuery("SELECT p FROM PERSON p WHERE p.name = :name", Person.class);
    }

    @Override
    public void add(Person person) {
        em.getTransaction().begin();
        try {
            em.persist(person.getPersonType());
            em.persist(person);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}
