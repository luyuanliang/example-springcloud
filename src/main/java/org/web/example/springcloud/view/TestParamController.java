package org.web.example.springcloud.view;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.web.example.springcloud.domain.StudentDO;
import org.web.example.springcloud.domain.DogDO;

@Controller
@RequestMapping("testParam")
public class TestParamController {

    @RequestMapping(value = "twoParams", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String twoParams(DogDO dogDO, StudentDO userDO) {
        String gson = new Gson().toJson(dogDO);
        gson = gson + "\n" + new Gson().toJson(userDO);
        return "CCC: \n"+gson;
    }

}
