package com.hib;

import com.hib.oneToOne.entities.Passport;
import com.hib.oneToOne.entities.Person;
import com.hib.oneToOne.services.PassportService;
import com.hib.oneToOne.services.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateSelfApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateSelfApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx, PersonService personService, PassportService passportService) {
        return args -> {
//            createPerson(personService, passportService);
            deletePerson(personService, passportService);
        };
    }


/***    In Hibernate, the default cascade type is NONE, meaning no
 *      cascading operations are performed unless explicitly specified.
 *      If you do not define any cascade type in your entity relationship,
 *      Hibernate will not propagate operations (like persist, merge,
 *      remove, etc.) to associated entities.
***/
    public void createPerson(PersonService personService, PassportService passportService) {
        Person person = new Person();
        person.setFirstName("Abhi");
        person.setLastName("Singh");

        Passport passport = new Passport();
        passport.setPassportNo("P69420");
        person.setPassport(passport);

//        passportService.save(passport); // Not required in CascadeType.ALL
        personService.save(person);

        System.out.println("Person have been saved");
    }

    public void deletePerson(PersonService personService, PassportService passportService) {
        Integer id = 4;
        personService.delete(id);
        System.out.printf("Person with id %d has been deleted%n", id);
    }


}
