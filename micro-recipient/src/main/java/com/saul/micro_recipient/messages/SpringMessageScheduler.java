package com.saul.micro_recipient.messages;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SpringMessageScheduler implements MessageScheduler{
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;
    private final MessagesService messagesService;

    public SpringMessageScheduler(RabbitTemplate rabbitTemplate, Queue queue, MessagesService messagesService) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
        this.messagesService = messagesService;
    }

    @Override
    @Scheduled(fixedRate = 5000)
    public void pollMessage() {
        Optional<String> message = Optional.ofNullable((String)rabbitTemplate.receiveAndConvert(queue.getName()));
        message.ifPresent(messagesService::addMessage);
    }
}
