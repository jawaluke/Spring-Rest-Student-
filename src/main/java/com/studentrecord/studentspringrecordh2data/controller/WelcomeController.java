package com.studentrecord.studentspringrecordh2data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

    // String To Wish
    String WishString = "Welcome User, Student RESTful Services";
    @RequestMapping(value="/")
    @ResponseBody
    public String welcomePageWish(){
        return WishString;
    }
}
