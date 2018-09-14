package my.antonov.study.dao.impl;

import my.antonov.study.dao.SubjectDao;
import my.antonov.study.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class SubjectDaoImpl implements SubjectDao {

    private EntityManager em;

    @Autowired
    public SubjectDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Subject> findAll() {
        return em.createQuery("SELECT s FROM Subject s").getResultList();
    }

    @Override
    public List<Subject> findSubjectByName(String name) {
        return em.createQuery("SELECT s FROM Subject s WHERE s.name = :name")
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public void add(Subject subject) {
        em.getTransaction().begin();
        try{
            em.persist(subject);
            em.getTransaction().commit();
        }  catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public List<Subject> findSubjects(List<String> names) {
        return em.createQuery("SELECT s FROM Subject s WHERE s.name IN :names")
                .setParameter("names", names)
                .getResultList();
    }
}
