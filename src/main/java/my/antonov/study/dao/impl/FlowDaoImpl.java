package my.antonov.study.dao.impl;

import my.antonov.study.dao.FlowDao;
import my.antonov.study.model.Flow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class FlowDaoImpl implements FlowDao {

    private EntityManager em;

    @Autowired
    public FlowDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Flow> findAll() {
        return em.createQuery("SELECT f FROM Flow f").getResultList();
    }

    @Override
    public List<Flow> findFlowByName(String name) {
        return em.createQuery("SELECT f FROM Flow f WHERE f.specName = :name")
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public void add(Flow flow) {
        em.getTransaction().begin();
        try{
            em.persist(flow);
            em.getTransaction().commit();
        }  catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}
