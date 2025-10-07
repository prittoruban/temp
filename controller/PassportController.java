package com.examly.springapp.controller;

import com.examly.springapp.model.Passport;
import com.examly.springapp.model.Person;
import com.examly.springapp.service.PassportService;
import com.examly.springapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PassportController {

    @Autowired
    private PassportService passportService;

    @Autowired
    private PersonService personService;

    @PostMapping("/passport")
    public ResponseEntity<Passport> createPassport(@RequestBody Passport passport) {
        try {
            Passport saved = passportService.savePassport(passport);
            return ResponseEntity.status(201).body(saved);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/passport")
    public ResponseEntity<List<Passport>> getAllPassports() {
        List<Passport> passports = passportService.getAllPassports();
        if (passports.isEmpty()) return ResponseEntity.status(404).build();
        return ResponseEntity.ok(passports);
    }

    @PostMapping("/person/passport/{passportId}")
    public ResponseEntity<Person> createPerson(@PathVariable int passportId, @RequestBody Person person) {
        try {
            Person saved = personService.savePerson(person, passportId);
            return ResponseEntity.status(201).body(saved);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/person/{personId}")
    public ResponseEntity<?> getPersonById(@PathVariable int personId) {
        return personService.getPersonById(personId)
                .map(p -> ResponseEntity.ok(p))
                .orElse(ResponseEntity.status(404).build());
    }

    @GetMapping("/person/search/name")
    public ResponseEntity<List<Person>> searchByName(@RequestParam String name) {
        List<Person> result = personService.searchByName(name);
        if (result.isEmpty()) return ResponseEntity.status(404).build();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/person/search/email")
    public ResponseEntity<List<Person>> searchByEmail(@RequestParam String email) {
        List<Person> result = personService.searchByEmail(email);
        if (result.isEmpty()) return ResponseEntity.status(404).build();
        return ResponseEntity.ok(result);
    }
}
