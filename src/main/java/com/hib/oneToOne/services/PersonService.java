package com.hib.oneToOne.services;

import com.hib.oneToOne.entities.Person;
import com.hib.oneToOne.repositories.PersonRepo;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepo personRepo;

    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Person save(Person person) {
        return personRepo.save(person);
    }

    public void delete(Integer id) {
        personRepo.deleteById(id);
    }
}
