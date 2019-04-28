package com.wj.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AmpqController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/ampq")
    public String amqpTest(){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "This is first message");
        map.put("data", Arrays.asList("helloworld", 123, true));


        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news", map);
        return "AMPQ";
    }

    @GetMapping("/get-ampq")
    public String getamqpTest(){

        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
        return "GET-AMPQ";
    }
}
