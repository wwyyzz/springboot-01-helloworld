package com.wj.controller;

import com.wj.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/async-hello")
    public String hello(){
        asyncService.hello();

        return "success";
    }
}
