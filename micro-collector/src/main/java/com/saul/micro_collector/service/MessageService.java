package com.saul.micro_collector.service;

import com.saul.micro_collector.model.Message;
import com.saul.micro_collector.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message create(Message message){
        return messageRepository.save(message);
    }
}
