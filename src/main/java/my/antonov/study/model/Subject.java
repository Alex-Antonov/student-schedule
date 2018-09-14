package my.antonov.study.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_seq_gen")
    @SequenceGenerator(name = "subject_seq_gen", sequenceName = "subject_id_seq", allocationSize = 1)
    private Long id;

    @Column
    private String name;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "tutor_subject", catalog = "db_schedule", joinColumns = {
//            @JoinColumn(name = "tutor_id", nullable = false, updatable = false) },
//            inverseJoinColumns = { @JoinColumn(name = "subject_id",
//                    nullable = false, updatable = false) })
//    private List<Tutor> tutors;

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
//        this.tutors = tutors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
