package com.example;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface PeopleApi {

    @GetMapping("/people")
    CollectionModel<Person> getPeople();

    @GetMapping("/people/{id}")
    ResponseEntity<Person> getPerson(@PathVariable int id);

}
