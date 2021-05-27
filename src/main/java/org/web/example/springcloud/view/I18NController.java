package org.web.example.springcloud.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("i18n")
public class I18NController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "sayLang", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String sayLang(HttpServletRequest request) {
        String lang = request.getParameter("lang");
        System.out.println("Lang is :    >>> " + lang);
        String message = null;
        String[] args = new String[]{"恒生"};
        if ("zh".equals(lang)) {
            message = messageSource.getMessage("code", args, Locale.CHINA);
        } else if ("en".equals(lang)) {
            message = messageSource.getMessage("code", args, Locale.US);
        } else {
            message = messageSource.getMessage("code", args, null);
        }
        return message;
    }
}
