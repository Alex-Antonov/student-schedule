package my.antonov.study.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tutor")
public class Tutor {

    @Id
    private Long id;

    private Person person;

    private List<Subject> subjects;

    private Degree degree;

    public Tutor() {
    }

    public Tutor(Person person, List<Subject> subjects, Degree degree) {
        this.person = person;
        this.subjects = subjects;
        this.degree = degree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }
}
