package com.tikalk.workshop.app;

import com.mongodb.MongoClient;
import com.tikalk.workshop.handler.PersonHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Spring 5 workshop application starter
 * Created by sigals on 03/03/2018.
 */
@SpringBootApplication
@ComponentScan({"com.tikalk.workshop.service", "com.tikalk.workshop.handler"})
@EnableReactiveMongoRepositories(basePackages = "com.tikalk.workshop.repository")
@EnableWebFlux
public class WorkshopApp {

    public static void main(String[] args) {
        SpringApplication.run(WorkshopApp.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> controller(PersonHandler handler) {
        return route(GET("/person/{id}").and(accept(APPLICATION_JSON)), handler::getPerson)
                .andRoute(GET("/person").and(accept(APPLICATION_JSON)), handler::listPeople)
                .andRoute(POST("/person"), handler::createPerson);
    }
}
