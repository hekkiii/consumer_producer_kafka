package com.example.consumer_producer_kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic2.name}")
    private String topicName2;

    @Bean
    public NewTopic FirstTopic(){
        return TopicBuilder.name("test").build();
    }

    @Bean
    public NewTopic SecondTopic(){
        return TopicBuilder.name("test2").build();
    }
}
