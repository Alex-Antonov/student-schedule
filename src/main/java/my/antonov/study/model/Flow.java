package my.antonov.study.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "flow")
public class Flow {

    @Id
    private Long id;

    @Column(name = "spec_name")
    private String specName;


    private List<Group> groups;

    public Flow() {
    }

    public Flow(String specName, List<Group> groups) {
        this.specName = specName;
        this.groups = groups;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
