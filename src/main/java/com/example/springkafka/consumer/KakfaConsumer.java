package com.example.springkafka.consumer;

import com.example.springkafka.repository.KafkaMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KakfaConsumer {

    @Autowired
    public KafkaMessageRepo kafkaMessageRepo;

    @KafkaListener(topics = "kafka-topic",groupId="consumer-group")
    public void consume(String message) {
        System.out.println("Message received at Consumer :" +message);
        kafkaMessageRepo.addMessage(message);

    }

}
