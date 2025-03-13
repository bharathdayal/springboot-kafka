package com.example.springkafka.controller;

import com.example.springkafka.producer.KafkaProducer;
import com.example.springkafka.repository.KafkaMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @Autowired
    public KafkaMessageRepo kafkaMessageRepo;

    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer=kafkaProducer;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        kafkaProducer.sendMessage(message);
        return "Message sent: " + message;
    }

    @GetMapping("/allmessage")
    public String getAllMessages() {
        return kafkaMessageRepo.getAllMessages();
    }
}
