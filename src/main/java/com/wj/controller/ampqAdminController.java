package com.wj.controller;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ampqAdminController {

    @Autowired
    AmqpAdmin amqpAdmin;

    @GetMapping("/createMQ")
    public String createExchange(){

        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue"));
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue", Binding.DestinationType.QUEUE, "amqpAdmin.exchange","amqp", null));

        return "create exchange success";
    }
}
