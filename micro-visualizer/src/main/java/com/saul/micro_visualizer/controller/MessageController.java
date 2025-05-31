package com.saul.micro_visualizer.controller;

import com.saul.micro_visualizer.model.Message;
import com.saul.micro_visualizer.repository.MessageRepository;
import com.saul.micro_visualizer.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/saved-messages")
public class MessageController {
    @Autowired
    private MessageService messageService;
    public ResponseEntity<List<Message>> getMessages(){
        return ResponseEntity.ok(messageService.read());
    }
}
