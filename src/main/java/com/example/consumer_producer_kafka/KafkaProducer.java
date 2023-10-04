package com.example.consumer_producer_kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.messaging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic2.name}")
    private String topicName2;

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, User> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessageToFirst(User user){
        Message<User> message = MessageBuilder
                    .withPayload(user)
                    .setHeader(KafkaHeaders.TOPIC, topicName)
                    .build();
        kafkaTemplate.send(message);
    }

    public void sendMessageToSecond(User user) throws JsonProcessingException {
        String json = "{\"login\":\"" + user.getLogin() +
                "\",\"password\":\"" + user.getPassword() + "\"," +
                "\"status\":\"OK\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(json);
        Message<JsonNode> message = MessageBuilder
                .withPayload(node)
                .setHeader(KafkaHeaders.TOPIC, topicName2)
                .build();
        kafkaTemplate.send(message);
    }
}
