package my.antonov.study.web.beans;

import my.antonov.study.model.Tutor;

import java.util.List;

public class TutorListBean {
    private List<Tutor> tutors;

    public TutorListBean(List<Tutor> tutors) {
        this.tutors = tutors;
    }

    public List<Tutor> getTutors() {
        return tutors;
    }
}
