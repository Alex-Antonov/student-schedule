package my.antonov.study.web.beans;

import my.antonov.study.model.Subject;

import java.util.List;

public class SubjectListBean {

    private List<Subject> subjects;

    public SubjectListBean(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
