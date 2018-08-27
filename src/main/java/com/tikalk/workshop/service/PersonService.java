package com.tikalk.workshop.service;

import com.tikalk.workshop.entity.Person;
import com.tikalk.workshop.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sigals on 10/03/2018.
 */
@Service
public class PersonService {

    private final static Logger LOG = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;

    public void storePersons(List<Person> persons) {
        persons
                .forEach(p -> {
                            LOG.info("Storing person {}", p);

                            personRepository.save(p);
                            LOG.info("Person {} stored", p);
                        }
                );
    }
}
