package com.tikalk.workshop.client;

import com.tikalk.workshop.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Random;

/**
 * Reactive REST controller client
 * Created by sigals on 19/09/2018.
 */
public class ControllerClient {

    private static final Random random = new Random();

    private static final Logger LOG = LoggerFactory.getLogger(ControllerClient.class);

    public static void main(String[] args) throws URISyntaxException {
        WebClient webClient = WebClient.create("http://localhost:8080/person");

        LOG.info("Sending request");

        webClient
                .post()
                .body(BodyInserters.fromPublisher(getPayload(), Person.class))
                .exchange()
                .doOnNext( p -> LOG.info("Received: {}", p.statusCode()))
                .block();
        LOG.info("Received response");
    }

    private static Flux<Person> getPayload() {

        return Flux.interval(Duration.ofSeconds(10)) // Create a Flux of Long numbers every 10 seconds
                .take(3) // Take 3 items
                .map(index -> new Person("first " + index, "last " + index)); // Map each item to a person instance
    }
}
