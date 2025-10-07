package com.examly.springapp.service;

import com.examly.springapp.model.Passport;
import java.util.List;
import java.util.Optional;

public interface PassportService {
    Passport savePassport(Passport passport);
    List<Passport> getAllPassports();
    Optional<Passport> getPassportById(int id);
}
