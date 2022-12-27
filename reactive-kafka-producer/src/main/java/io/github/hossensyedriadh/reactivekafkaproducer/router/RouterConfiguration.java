package io.github.hossensyedriadh.reactivekafkaproducer.router;

import io.github.hossensyedriadh.reactivekafkaproducer.handler.ProducerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfiguration {
    private final ProducerHandler producerHandler;

    @Autowired
    public RouterConfiguration(ProducerHandler producerHandler) {
        this.producerHandler = producerHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> route() {
        return RouterFunctions.route(RequestPredicates.POST("/producer/")
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), this.producerHandler::publish);
    }
}
