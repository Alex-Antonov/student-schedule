package my.antonov.study.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    private Long id;

    private Person person;

    private Group group;

    @Column(name = "is_hostel_inh")
    private boolean isHostelInh;

    @Column(name = "is_grants")
    private boolean isGrants;

    public Student() {
    }

    public Student(Person person, Group group, boolean isHostelInh, boolean isGrants) {
        this.person = person;
        this.group = group;
        this.isHostelInh = isHostelInh;
        this.isGrants = isGrants;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
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
