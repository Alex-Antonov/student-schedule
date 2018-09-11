package my.antonov.study.web.servlets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainPageController {

    @RequestMapping(method = RequestMethod.GET, path = "/main")
    public String addStudentShowForm() {
        return "main";
    }
}
