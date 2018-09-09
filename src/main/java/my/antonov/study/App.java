package my.antonov.study;


import my.antonov.study.dao.GroupDao;
import my.antonov.study.dao.StudentDao;
import my.antonov.study.dao.impl.GroupDaoImpl;
import my.antonov.study.dao.impl.StudentDaoIml;
import my.antonov.study.model.Groups;
import my.antonov.study.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = emf.createEntityManager();

//        try {
//            PersonDao personDao = new PersonDaoImpl(em);
//            PersonType personType = new PersonType("ADMIN");
//            Person person = new Person("admin", "adminov", "adminovich",
//                    "+7(999)-999-99-99", "olol@lo.lol", personType, null);
//            personDao.add(person);
//
//        } finally {
//            em.close();
//            emf.close();
//        }
//        try {
//            PersonDao personDao = new PersonDaoImpl(em);
//            personDao.findPersonByName("admin");
//        } finally {
//            em.close();
//            emf.close();
//        }
        try {
            StudentDao studentDao = new StudentDaoIml(em);
//            GroupDao groupDao = new GroupDaoImpl(em);
//
//            Student student = new Student();
//            student.setGrants(true);
//            student.setHostelInh(true);
//
//            //Groups group = groupDao.findGroupByName("АП-16").get(0);
//            //System.out.println(group.getName());
//
//            //student.setGroup(group);
//            student.setEmail("kat@liza.tor");
//            student.setFirstName("Pupok");
//            student.setSecondName("Pupkin");
//            student.setLastName("Pupkovich");
//            student.setPersonType("STUD");
//            student.setPhone("+7(999)123-54-67");
//
//
//            studentDao.add(student);
            List<Student> studentList = studentDao.findAll();

            for(Student s : studentList) System.out.println(s.getEmail());
        } finally {
            em.close();
            emf.close();
        }
    }
}
