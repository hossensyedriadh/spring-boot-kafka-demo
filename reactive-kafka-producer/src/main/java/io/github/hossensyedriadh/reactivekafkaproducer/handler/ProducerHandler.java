package io.github.hossensyedriadh.reactivekafkaproducer.handler;

import io.github.hossensyedriadh.reactivekafkaproducer.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ProducerHandler {
    private final ReactiveKafkaProducerTemplate<String, Country> reactiveKafkaProducerTemplate;

    @Value("${kafka.producer.topic}")
    private String topic;

    @Autowired
    public ProducerHandler(ReactiveKafkaProducerTemplate<String, Country> reactiveKafkaProducerTemplate) {
        this.reactiveKafkaProducerTemplate = reactiveKafkaProducerTemplate;
    }

    public Mono<ServerResponse> publish(ServerRequest serverRequest) {
        Mono<Country> countryMono = serverRequest.bodyToMono(Country.class);

        return countryMono.flatMap(country -> this.reactiveKafkaProducerTemplate.send(this.topic, country)
                .then(ServerResponse.noContent().build()));
    }
}
