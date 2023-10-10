package com.example;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PeopleRepository {

    public List<Person> getPeople() {
        var people = new ArrayList<Person>();
        people.add(new Person(1,"John", 30));
        people.add(new Person(2,"Mary", 27));
        people.add(new Person(3,"Bob", 10));
        return people;
    }

    public Optional<Person> getPerson(int id) {
        return getPeople().stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

}
