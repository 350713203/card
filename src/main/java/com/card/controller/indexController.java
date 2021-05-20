package com.card.controller;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class indexController {

    /***
     * 返回系统的首页页面
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    @RequestMapping("/shuaka")
    public String user(){
        return "pages/shuaka";
    }

    /**
     * test.post
     */
    @RequestMapping("/testPost")
    public String post(){
        return "测试POst提交";
    }

}
