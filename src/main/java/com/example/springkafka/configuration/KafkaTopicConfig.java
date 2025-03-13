package com.example.springkafka.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class KafkaTopicConfig {

    @Bean
    public NewTopic kafkaTopic(){
        return new NewTopic("kafka-topic",1, (short) 1);
    }
}
