package com.tikalk.workshop.controller;

import com.tikalk.workshop.entity.Person;
import com.tikalk.workshop.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by sigals on 03/03/2018.
 */
@RestController
@RequestMapping(value = "/person", produces = "application/json")
public class PersonController {

    private final static Logger LOG = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postPersons(@Valid @RequestBody List<Person> persons) {
        LOG.info("Received request");
        personService.storePersons(persons);
        LOG.info("Request processed");
    }
}
