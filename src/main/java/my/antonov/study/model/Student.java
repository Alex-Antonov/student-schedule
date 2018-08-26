package my.antonov.study.model;

public class Student {

    private Person person;
    private Group group;
    private boolean isHostelInh;
    private boolean isGrants;

    public Student() {
    }

    public Student(Person person, Group group, boolean isHostelInh, boolean isGrants) {
        this.person = person;
        this.group = group;
        this.isHostelInh = isHostelInh;
        this.isGrants = isGrants;
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
