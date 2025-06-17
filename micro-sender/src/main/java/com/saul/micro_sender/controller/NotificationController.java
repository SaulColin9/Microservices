package com.saul.micro_sender.controller;

import com.saul.micro_sender.model.User;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private TopicExchange exchange;

    @Autowired
    private MeterRegistry meterRegistry;

    @PostMapping
    public ResponseEntity<User> sendMessage(@RequestBody User user){
        String message = user.getMessage();
        String name = nameFormatter(user.getName());
        rabbitTemplate.convertAndSend(exchange.getName(),"notification", message);
        logger.info("POST /notification called with user: {} and message: {}", name, message);

        Counter notiCounter = Counter.builder("notifications_count")
                .tag("message", message)
                .description("The number of notifications sent so far")
                .register(meterRegistry);
        notiCounter.increment();

        Counter userCounter = Counter.builder("user_count")
                .tag("user", user.getName())
                .description("Number of notifications sent by a user")
                .register(meterRegistry);
        userCounter.increment();

        return ResponseEntity.ok(user);
    }

    private String nameFormatter(String name){
        return String.join("-", name.split(" "));
    }
}
