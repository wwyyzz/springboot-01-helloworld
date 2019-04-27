package com.wj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("test");
        simpleMailMessage.setText("this is test");
        simpleMailMessage.setTo("wwyyzz08@sina.com");
        simpleMailMessage.setFrom("wwyyzz08@163.com");

        javaMailSender.send(simpleMailMessage);

        return "Hello World";
    }
}
