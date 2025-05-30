package com.saul.micro_recipient.messages;

import java.util.List;

public interface MessagesService {
    List<String> readMessages();
    void cleanMessages();
    void addMessage(String message);
}
