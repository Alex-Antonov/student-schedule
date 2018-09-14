package my.antonov.study.dao;

import my.antonov.study.TestConfiguration;
import my.antonov.study.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = TestConfiguration.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class DaoSmokeTest {
//    @Autowired
//    private EntityManager em;
//
//    @Autowired
//    private StudentDao studentDao;
//
//    @Test
//    public void studentAdd() {
//        Student student = new Student("firstName", "secondName", "lastName", "phone", "email", "STUD", null, null, true, false);
//        studentDao.add(student);
//
//        assertEquals(student, em.find(Student.class, 1));
//    }
//
//    @Test(expected = EntityExistsException.class)
//    public void userAddConstraintViolation() {
//        studentDao.add(new Student("firstName", "secondName", "lastName", "phone", "email", "STUD", null, null, true, false));
//        studentDao.add(new Student("firstName", "secondName", "lastName", "phone", "email", "STUD", null, null, true, false));
//    }

//    @Test
//    public void eventsAddAndSearch() {
//        Date now = new Date();
//        Event event = new Event("test", "test", now, now);
//
//        eventsDAO.add(event);
//
//        List<Event> found = eventsDAO.findEvents(now);
//        assertEquals(1, found.size());
//        assertEquals(event, found.get(0));
//    }
}
