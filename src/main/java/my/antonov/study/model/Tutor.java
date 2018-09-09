package my.antonov.study.model;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("TUT")
@Table(name = "tutor")
public class Tutor extends Person {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tutor_seq_gen")
//    @SequenceGenerator(name = "tutor_seq_gen", sequenceName = "tutor_id_seq", allocationSize = 1)
//    private Long id;

//    @OneToOne
//    @JoinColumn(name = "id")
//    private Person person;

    @ManyToMany
    @JoinColumn(name = "subject_id")
    private List<Subject> subjects;

    @Column
    private String degree;

    public Tutor() {
    }

//    public Tutor(Person person, List<Subject> subjects, String degree) {
//        this.person = person;
//        this.subjects = subjects;
//        this.degree = degree;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }

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
}
