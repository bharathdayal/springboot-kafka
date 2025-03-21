package com.example.springkafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String,String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String,String> kafkaTemplate) {
        this.kafkaTemplate=kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send("kafka-topic",message);
        System.out.println("Message Sent from Producer :" +message);
    }
}
