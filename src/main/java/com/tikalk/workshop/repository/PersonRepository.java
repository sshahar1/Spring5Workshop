package com.tikalk.workshop.repository;

import com.tikalk.workshop.entity.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Person CRUD repository actions
 * Created by sigals on 10/03/2018.
 */
@Repository
public interface PersonRepository extends ReactiveCrudRepository<Person, Long> {
}
