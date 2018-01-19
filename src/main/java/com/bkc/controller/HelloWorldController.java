package com.bkc.controller;

import com.bkc.pojo.Person;
import com.bkc.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "test")
public class HelloWorldController {

    @Autowired GreetingService greetingService;

    @RequestMapping(value = "hello")
    @ResponseBody
    public String returnString(
        @RequestParam("userName") String userName,
        @RequestParam("password") String password,
        Model model) {
        greetingService.sayMessage("BKC ");
        return "hello return string 这是中文" + userName + "-" + password;
    }

    @RequestMapping(value = "global")
    @ResponseBody
    public String globalTest(Model model) {
        Person p = null;
        return "hello return string 这是中文" + p.toString();
    }


}

