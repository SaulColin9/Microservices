package com.saul.micro_collector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Collector {
    @Autowired
    private RecipientClient recipientClient;
    private static final Logger logger = LoggerFactory.getLogger(Collector.class);

    @Scheduled(fixedRate = 10000, initialDelay = 5000)
    private void logMessages(){
        logger.info(recipientClient.getMessages().toString());
    }
}
