package com.tikalk.workshop.handler;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Created by sigals on 06/10/2018.
 */
@Service
public class PersonHandler {
    public <T extends ServerResponse> Mono<T> getPerson(ServerRequest serverRequest) {
        return null;
    }

    public Mono<ServerResponse> listPeople(ServerRequest serverRequest) {
        return null;
    }

    public Mono<ServerResponse> createPerson(ServerRequest serverRequest) {
        return null;
    }
}
