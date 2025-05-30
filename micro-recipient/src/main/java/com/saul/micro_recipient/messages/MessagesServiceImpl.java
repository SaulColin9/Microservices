package com.saul.micro_recipient.messages;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesServiceImpl implements MessagesService{
    private final List<String> messages;

    public MessagesServiceImpl(List<String> messages) {
        this.messages = messages;
    }

    @Override
    public List<String> readMessages() {
        return messages;
    }

    @Override
    public void cleanMessages() {
        messages.clear();
    }

    @Override
    public void addMessage(String message) {
        messages.add(message);
    }
}
