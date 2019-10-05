package com.suresh.kafkaproject;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private Producer producer;

    @GetMapping("/status")
    public String status(@RequestBody Customer customer) {


        producer.sendMessage(customer);
        return "Hello " + customer.getName();
    }
}
