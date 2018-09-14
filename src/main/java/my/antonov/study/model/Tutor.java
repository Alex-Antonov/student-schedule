package my.antonov.study.model;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("TUTOR")
@Table(name = "tutor")
public class Tutor extends Person {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tutor_subject"/*, catalog = "db_schedule"*/, joinColumns = {
            @JoinColumn(name = "tutor_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "subject_id",
                    nullable = false, updatable = false) })
    private List<Subject> subjects;

    @Column
    private String degree;

    @Column
    private int experience;

    public Tutor() {
    }

    public Tutor(String firstName, String secondName, String lastName, String phone, String email, String personType, User user, List<Subject> subjects, String degree, int experience) {
        super(firstName, secondName, lastName, phone, email, personType, user);
        this.subjects = subjects;
        this.degree = degree;
        this.experience = experience;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
