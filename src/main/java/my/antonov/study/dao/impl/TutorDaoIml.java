package my.antonov.study.dao.impl;

import my.antonov.study.dao.TutorDao;
import my.antonov.study.model.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class TutorDaoIml implements TutorDao {

    private EntityManager em;

    @Autowired
    public TutorDaoIml(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Tutor> findTutorByName(String name) {
        return em.createQuery("SELECT t FROM Tutor t WHERE t.firstName = :name")
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public void add(Tutor tutor) {
        em.getTransaction().begin();
        try{
            em.persist(tutor);
            em.getTransaction().commit();
        }  catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public List<Tutor> findAll() {
        return em.createQuery("SELECT t FROM Tutor t").getResultList();
    }
}
