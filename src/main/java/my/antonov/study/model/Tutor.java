package my.antonov.study.model;

import java.util.List;

public class Tutor {

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
