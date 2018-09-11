package my.antonov.study.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "flow")
public class Flow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flow_seq_gen")
    @SequenceGenerator(name = "flow_seq_gen", sequenceName = "flow_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "spec_name")
    private String specName;

    @OneToMany(mappedBy = "flow", cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Groups> groups;

    public Flow() {
    }

    public Flow(String specName, List<Groups> groups) {
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

    public List<Groups> getGroups() {
        return groups;
    }

    public void setGroups(List<Groups> groups) {
        this.groups = groups;
    }
}
