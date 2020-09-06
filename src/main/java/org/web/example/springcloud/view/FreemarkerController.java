package org.web.example.springcloud.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.web.example.springcloud.domain.StudentDO;

import java.util.ArrayList;

@Controller
@RequestMapping("freemarker")
public class FreemarkerController {

    @RequestMapping(value = "sayFreeMarker", method = {RequestMethod.POST, RequestMethod.GET})
    public String sayFreeMark(Model model) {
        model.addAttribute("account","freemarker");
        StudentDO studentDO  = new StudentDO();
        studentDO.setAge(2);
        studentDO.setHomeaddress("China");
        model.addAttribute("student",studentDO);
        return "sayFreeMarker";
    }
}
