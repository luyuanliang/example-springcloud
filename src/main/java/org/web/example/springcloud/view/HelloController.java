package org.web.example.springcloud.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("hello")
public class HelloController {

    @RequestMapping(value = "first", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String first() {
        return "aaa";
    }

}
