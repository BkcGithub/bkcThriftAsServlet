package com.bkc.controller;

import com.bkc.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "test")
public class Hello {

    @RequestMapping(value = "hello")
    @ResponseBody
    public String returnString(Model model) {
        return "hello return string 这是中文";
    }

    @RequestMapping(value = "global")
    @ResponseBody
    public String globalTest(Model model) {
        Person p = null;
        return "hello return string 这是中文" + p.toString();
    }


}

