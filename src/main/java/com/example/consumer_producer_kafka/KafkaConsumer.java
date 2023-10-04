package com.example.consumer_producer_kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private final KafkaProducer kafkaProducer;

    public KafkaConsumer(KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String data) throws JsonProcessingException {
        File file = new File();
        file.toFile(data);
        User user = new ObjectMapper().readValue(data, User.class);
        kafkaProducer.sendMessageToSecond(user);
    }
}
