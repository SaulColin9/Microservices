package com.saul.micro_recipient.controller;

import com.saul.micro_recipient.messages.MessagesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessagesService messagesService;

    @GetMapping
    public List<String> getMessages(){
        List<String> messages = new ArrayList<>(messagesService.readMessages());
        logger.info("GET /message called");
        messagesService.cleanMessages();
        return messages.stream().limit(1).toList();
    }
}
