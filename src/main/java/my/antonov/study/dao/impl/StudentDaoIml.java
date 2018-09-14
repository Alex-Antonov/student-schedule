package my.antonov.study.dao.impl;

import my.antonov.study.dao.StudentDao;
import my.antonov.study.model.Groups;
import my.antonov.study.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class StudentDaoIml implements StudentDao {

    private EntityManager em;

    @Autowired
    public StudentDaoIml(EntityManager em) {
        this.em = em;
    }

    @Override
    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> findStudentByName(String name) {
        return em.createQuery("SELECT s FROM Student s WHERE s.firstName = :name")
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public List<Student> findStudentByGroup(Groups group) {
        return em.createQuery("SELECT s FROM Student s WHERE s.group.name = :name")
                .setParameter("name", group.getName())
                .getResultList();
    }

    @Override
    public List<Student> findAll() {
        return em.createQuery("SELECT s FROM Student s").getResultList();
    }

    @Override
    public void add(Student student) {
        em.getTransaction().begin();
        try {
            em.persist(student);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void update(Student student) {
        em.getTransaction().begin();
        try {
            em.merge(student);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        try {
            int isSuccessful = em.createQuery("delete from Student s where s.id=:id")
                    .setParameter("id", id)
                    .executeUpdate();
            em.getTransaction().commit();
            if (isSuccessful == 0) {
                throw new OptimisticLockException(" Student modified concurrently");
            }
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}
