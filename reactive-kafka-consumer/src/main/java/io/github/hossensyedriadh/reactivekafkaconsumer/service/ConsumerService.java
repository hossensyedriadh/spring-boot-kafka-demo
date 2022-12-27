package io.github.hossensyedriadh.reactivekafkaconsumer.service;

import io.github.hossensyedriadh.reactivekafkaconsumer.model.Country;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ConsumerService implements CommandLineRunner {
    private final Logger log = LoggerFactory.getLogger(ConsumerService.class);
    private final ReactiveKafkaConsumerTemplate<String, Country> reactiveKafkaConsumerTemplate;

    @Autowired
    public ConsumerService(ReactiveKafkaConsumerTemplate<String, Country> reactiveKafkaConsumerTemplate) {
        this.reactiveKafkaConsumerTemplate = reactiveKafkaConsumerTemplate;
    }

    private Flux<Country> listen() {
        return this.reactiveKafkaConsumerTemplate.receiveAutoAck().map(ConsumerRecord::value).doOnNext(country -> log.info("New message in queue: {}", country))
                .doOnError(throwable -> log.error("Consumption error: {}", throwable.getMessage()));
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     */
    @Override
    public void run(String... args) {
        this.listen().subscribe();
    }
}
