package com.examly.springapp.service;

import com.examly.springapp.model.Person;
import java.util.List;
import java.util.Optional;

public interface PersonService {
    Person savePerson(Person person, int passportId);
    Optional<Person> getPersonById(int id);
    List<Person> searchByName(String name);
    List<Person> searchByEmail(String email);
}
