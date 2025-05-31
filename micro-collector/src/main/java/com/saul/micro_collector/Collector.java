package com.saul.micro_collector;

import com.saul.micro_collector.model.Message;
import com.saul.micro_collector.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Collector {
    @Autowired
    private RecipientClient recipientClient;

    @Autowired
    private MessageService messageService;

    private static final Logger logger = LoggerFactory.getLogger(Collector.class);

    @Scheduled(fixedRate = 5*10000, initialDelay = 5000)
    private void logMessages(){
        recipientClient.getMessages().stream()
                .limit(1)
                .map(Message::new)
                .forEach(messageService::create);

        logger.info(recipientClient.getMessages().toString());
    }
}
