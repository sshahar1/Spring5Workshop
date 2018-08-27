package com.tikalk.workshop.controller;

import com.tikalk.workshop.app.WorkshopApp;
import com.tikalk.workshop.entity.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import static org.junit.Assert.*;

/**
 * Created by sigals on 10/03/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {PersonController.class, WorkshopApp.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerTest {
    private WebClient webClient;

    @LocalServerPort
    private int port;

    @Before
    public void setUp() throws Exception {
        this.webClient =
                WebClient.builder()
                        .clientConnector(new ReactorClientHttpConnector())
                        .build();
    }

    @Test
    public void person() throws Exception {

        Person person;
//        ClientRequest<Flux<Person>> request = ClientRequest
//                .POST("http://localhost:{port}/location/address", this.port)
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(Flux.just(person), Person.class);
//
//        Flux<Person> result = this.webClient
//                .exchange(request)
//                .flatMap(response -> response.bodyToFlux(Person.class));
//
//        ScriptedSubscriber.<Person>create()
//                .consumeNextWith(address -> {
//                    assertEquals("Rome", address.getCity());
//                })
//                .expectComplete()
//                .verify(result);

    }
}