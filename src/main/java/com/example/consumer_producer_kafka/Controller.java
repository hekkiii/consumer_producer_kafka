package com.example.consumer_producer_kafka;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final KafkaProducer kafkaProducer;

    public Controller(KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/produce")
    public ResponseEntity<String> produce(@RequestBody User user){
        kafkaProducer.sendMessageToFirst(user);
        return ResponseEntity.ok("JSON message sent to first topic");
    }
}
