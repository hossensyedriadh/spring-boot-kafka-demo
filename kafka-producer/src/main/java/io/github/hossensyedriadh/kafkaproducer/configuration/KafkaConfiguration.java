package io.github.hossensyedriadh.kafkaproducer.configuration;

import io.github.hossensyedriadh.kafkaproducer.model.Country;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfiguration {
    private final Map<String, Object> configProps = Map.of(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092",
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

    @Bean
    public ProducerFactory<String, Country> producerFactory() {
        return new DefaultKafkaProducerFactory<>(this.configProps);
    }

    @Bean
    public KafkaTemplate<String, Country> kafkaTemplate() {
        return new KafkaTemplate<>(this.producerFactory());
    }
}
