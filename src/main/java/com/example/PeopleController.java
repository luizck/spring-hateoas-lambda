package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.BasicLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleController implements PeopleApi {

    private PeopleRepository peopleRepository;

    @Autowired
    public PeopleController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public CollectionModel<Person> getPeople() {
        var people = peopleRepository.getPeople();
        people.forEach(p -> p.add(BasicLinkBuilder
                .linkToCurrentMapping()
                .slash("person")
                .slash(p.getId())
                .withSelfRel()));
        return CollectionModel.of(people);
    }

    @Override
    public ResponseEntity<Person> getPerson(int id) {
        var optional = peopleRepository.getPerson(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else
            return ResponseEntity.notFound().build();
    }
}
