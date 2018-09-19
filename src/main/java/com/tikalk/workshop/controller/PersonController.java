package com.tikalk.workshop.controller;

import com.tikalk.workshop.entity.Person;
import com.tikalk.workshop.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import javax.validation.Valid;
import java.util.List;

/**
 * Reactive REST controller for persons
 * Created by sigals on 03/03/2018.
 */
@RestController
@RequestMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    private final static Logger LOG = LoggerFactory.getLogger(PersonController.class);

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Flux<Person> postPersons(@Valid @RequestBody Flux<Person> persons) {
        LOG.info("Received request");
        Flux<Person> created = personService.storePersonsFlux(persons);
        LOG.info("Request processed");
        return created;
    }

    @GetMapping
    public Flux<Person> getAll() {
        return personService.getAll();
    }
}
