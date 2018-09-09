package my.antonov.study.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("STUD")
@Table(name = "student")
public class Student extends Person {
//
//    @Id
//    private Long id;

//    @OneToOne
//    @JoinColumn(name = "id")
//    private Person person;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "group_id")
    private Groups group;

    @Column(name = "is_hostel_inh")
    private boolean isHostelInh;

    @Column(name = "is_grants")
    private boolean isGrants;

    public Student() {
    }

    public Student(String firstName, String secondName, String lastName, String phone, String email, String personType, User user, Groups group, boolean isHostelInh, boolean isGrants) {
        super(firstName, secondName, lastName, phone, email, personType, user);
        this.group = group;
        this.isHostelInh = isHostelInh;
        this.isGrants = isGrants;
    }
//    public Student(Person person, Groups group, boolean isHostelInh, boolean isGrants) {
//        //this.person = person;
//        this.group = group;
//        this.isHostelInh = isHostelInh;
//        this.isGrants = isGrants;
//    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }

    public boolean isHostelInh() {
        return isHostelInh;
    }

    public void setHostelInh(boolean hostelInh) {
        isHostelInh = hostelInh;
    }

    public boolean isGrants() {
        return isGrants;
    }

    public void setGrants(boolean grants) {
        isGrants = grants;
    }
}
