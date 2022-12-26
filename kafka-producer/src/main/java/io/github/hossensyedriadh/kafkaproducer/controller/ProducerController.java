package io.github.hossensyedriadh.kafkaproducer.controller;

import io.github.hossensyedriadh.kafkaproducer.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/producer", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProducerController {
    private final KafkaTemplate<String, Country> kafkaTemplate;

    @Value("${kafka.producer.topic}")
    private String topic;

    @Autowired
    public ProducerController(KafkaTemplate<String, Country> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping(value = "/", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> publish(@RequestBody Country country) {
        try {
            this.kafkaTemplate.send(this.topic, country);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
