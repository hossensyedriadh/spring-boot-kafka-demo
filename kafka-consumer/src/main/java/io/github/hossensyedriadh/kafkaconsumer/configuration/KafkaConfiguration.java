package io.github.hossensyedriadh.kafkaconsumer.configuration;

import io.github.hossensyedriadh.kafkaconsumer.model.Country;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfiguration {
    @Bean
    public ConsumerFactory<String, Country> consumerFactory() {
        Map<String, Object> configProps = Map.of(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092",
                ConsumerConfig.GROUP_ID_CONFIG, "countries",
                JsonDeserializer.TRUSTED_PACKAGES, "*",
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(configProps, new StringDeserializer(),
                new JsonDeserializer<>(Country.class, false));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Country> countryListener() {
        ConcurrentKafkaListenerContainerFactory<String, Country> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(this.consumerFactory());
        return factory;
    }
}
