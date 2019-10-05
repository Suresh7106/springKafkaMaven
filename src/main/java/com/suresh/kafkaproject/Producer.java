package com.suresh.kafkaproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Producer {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "users";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(Customer customer) {
        try {
            logger.info(String.format("$$ -> Producing message --> %s", customer));
            this.kafkaTemplate.send(TOPIC, new ObjectMapper().writeValueAsString(customer));
        } catch (IOException ex ) {
            logger.error("exception occurred", ex);
        }
    }
}
