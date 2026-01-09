package com.kafka.provider.controllers;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class ProviderController {

    private final KafkaTemplate KafkaTemplate;

    public ProviderController(KafkaTemplate kafkaTemplate) {
        KafkaTemplate = kafkaTemplate;
    }


    @PostMapping("new")
    public ResponseEntity<?> sendNewMessage(){

        KafkaTemplate.send("firstTopic", "Hello people");


        return new ResponseEntity<>("hello", HttpStatus.OK);
    }


}
