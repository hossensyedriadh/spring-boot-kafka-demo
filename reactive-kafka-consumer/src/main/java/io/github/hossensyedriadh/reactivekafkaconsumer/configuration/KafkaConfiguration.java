package io.github.hossensyedriadh.reactivekafkaconsumer.configuration;

import io.github.hossensyedriadh.reactivekafkaconsumer.model.Country;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import reactor.kafka.receiver.ReceiverOptions;

import java.util.Collections;

@EnableKafka
@Configuration
public class KafkaConfiguration {
    @Bean
    public ReceiverOptions<String, Country> receiverOptions(@Value("${kafka.consumer.topic}") String topic, KafkaProperties kafkaProperties) {
        ReceiverOptions<String, Country> receiverOptions = ReceiverOptions.create(kafkaProperties.buildConsumerProperties());
        return receiverOptions.subscription(Collections.singletonList(topic));
    }

    @Bean
    public ReactiveKafkaConsumerTemplate<String, Country> reactiveKafkaConsumerTemplate(ReceiverOptions<String, Country> receiverOptions) {
        return new ReactiveKafkaConsumerTemplate<>(receiverOptions);
    }
}
