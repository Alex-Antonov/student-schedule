package my.antonov.study.dao.impl;

import my.antonov.study.dao.GroupDao;
import my.antonov.study.model.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class GroupDaoImpl implements GroupDao {

    private EntityManager em;

    @Autowired
    public GroupDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void add(Groups group) {
        em.getTransaction().begin();
        try{
            em.persist(group);
            em.getTransaction().commit();
        }  catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public List<Groups> findGroupByName(String name) {
        return em.createQuery("SELECT g FROM Groups g WHERE g.name = :n").setParameter("n", name).getResultList();
    }

    @Override
    public List<Groups> findAll() {
        return em.createQuery("SELECT g FROM Groups g").getResultList();
    }
}
