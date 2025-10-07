package com.examly.springapp.service;

import com.examly.springapp.model.Person;
import com.examly.springapp.model.Passport;
import com.examly.springapp.repository.PersonRepository;
import com.examly.springapp.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PassportRepository passportRepository;

    @Override
    public Person savePerson(Person person, int passportId) {
        Optional<Passport> passportOpt = passportRepository.findById(passportId);
        if (passportOpt.isPresent()) {
            Passport passport = passportOpt.get();
            person.setPassport(passport);
            return personRepository.save(person);
        }
        return null;
    }

    @Override
    public Optional<Person> getPersonById(int id) {
        return personRepository.findById(id);
    }

    @Override
    public List<Person> searchByName(String name) {
        return personRepository.findByName(name);
    }

    @Override
    public List<Person> searchByEmail(String email) {
        return personRepository.findByEmail(email);
    }
}
