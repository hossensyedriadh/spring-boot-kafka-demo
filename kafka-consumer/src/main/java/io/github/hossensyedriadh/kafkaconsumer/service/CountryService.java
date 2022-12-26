package io.github.hossensyedriadh.kafkaconsumer.service;

import io.github.hossensyedriadh.kafkaconsumer.model.Country;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    @KafkaListener(topics = {"country"}, groupId = "countries", containerFactory = "countryListener")
    public void listen(Country country) {
        System.out.println("New message in queue: " + country);
    }
}
