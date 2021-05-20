package com.card.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testFormController {

    @RequestMapping("/testForm")
    public String testForm(){
        return "testForm";
    }

    @ResponseBody
    @RequestMapping("/testForm/ajax")
    public String fromAjax(String string){

        return string;
    }

}
