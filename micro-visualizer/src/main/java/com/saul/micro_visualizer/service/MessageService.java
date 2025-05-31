package com.saul.micro_visualizer.service;

import com.saul.micro_visualizer.model.Message;
import com.saul.micro_visualizer.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> read(){
        return messageRepository.findAll();
    }
}
