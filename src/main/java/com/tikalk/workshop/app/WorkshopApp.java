package com.tikalk.workshop.app;

import com.mongodb.MongoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * Spring 5 workshop application starter
 * Created by sigals on 03/03/2018.
 */
@SpringBootApplication
@ComponentScan({"com.tikalk.workshop.controller", "com.tikalk.workshop.service"})
@EnableReactiveMongoRepositories(basePackages = "com.tikalk.workshop.repository")
@EnableWebFlux
public class WorkshopApp {

    public static void main(String[] args) {
        SpringApplication.run(WorkshopApp.class, args);
    }

    @Bean
    public MongoClient mongoClient() {
        // connect to embedded mongodb
        return new MongoClient();
    }
}
