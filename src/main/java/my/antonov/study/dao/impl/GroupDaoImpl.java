package my.antonov.study.dao.impl;

import my.antonov.study.dao.GroupDao;
import my.antonov.study.model.Groups;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by alex on 03.09.2018.
 */
public class GroupDaoImpl implements GroupDao {

    private EntityManager em;

    public GroupDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void add(Groups group) {

    }

    @Override
    public List<Groups> findGroupByName(String name) {
        Long id = 1L;
        return em.createQuery("SELECT g FROM Groups g WHERE g.id = :n").setParameter("n", id).getResultList();
    }
}
