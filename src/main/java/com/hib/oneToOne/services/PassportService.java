package com.hib.oneToOne.services;

import com.hib.oneToOne.entities.Passport;
import com.hib.oneToOne.repositories.PassportRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PassportService {
    private final PassportRepo passportRepo;

    public PassportService(PassportRepo passportRepo) {
        this.passportRepo = passportRepo;
    }

    public Passport getPassport(Integer id) {
        return passportRepo.findById(id).orElse(null);
    }

    public Passport save(Passport passport) {
        return passportRepo.save(passport);
    }

    public void delete(Integer id) {
        passportRepo.deleteById(id);
    }
}
