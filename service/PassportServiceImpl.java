package com.examly.springapp.service;

import com.examly.springapp.model.Passport;
import com.examly.springapp.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PassportServiceImpl implements PassportService {

    @Autowired
    private PassportRepository passportRepository;

    @Override
    public Passport savePassport(Passport passport) {
        return passportRepository.save(passport);
    }

    @Override
    public List<Passport> getAllPassports() {
        return passportRepository.findAll();
    }

    @Override
    public Optional<Passport> getPassportById(int id) {
        return passportRepository.findById(id);
    }
}
