package com.hib;

import com.hib.oneToMany.entities.Course;
import com.hib.oneToMany.entities.Instructor;
import com.hib.oneToMany.repository.CourseRepo;
import com.hib.oneToMany.repository.InstructorRepo;
import com.hib.oneToOne.entities.Passport;
import com.hib.oneToOne.entities.Person;
import com.hib.oneToOne.services.PassportService;
import com.hib.oneToOne.services.PersonService;
import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class HibernateSelfApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateSelfApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx,
                                        PersonService personService, PassportService passportService,
                                        InstructorRepo instructorRepo, CourseRepo courseRepo
                                        ) {
        return args -> {

//            One to One Mappings
//            createPerson(personService, passportService);
//            deletePerson(personService, passportService);
//            printPassport(passportService);

//            OneToMany / ManyToOne mappings
//            createInstructorWithCourses(instructorRepo, courseRepo);
              findInstructorWithCourses(instructorRepo, courseRepo);
        };
    }

    private void findInstructorWithCourses(InstructorRepo instructorRepo, CourseRepo courseRepo) {
        Instructor instructor = instructorRepo.findById(1L).orElse(null);
        System.out.println(instructor);
        System.out.println(" ---------------------- ");
        assert instructor != null;
        System.out.println(instructor.getCourses());
    }

    private void createInstructorWithCourses(InstructorRepo instructorRepo, CourseRepo courseRepo) {
        Instructor instructor = new Instructor();
        instructor.setFirstName("John");
        instructor.setLastName("Smith");
        instructor.setEmail("john.smith@gmail.com");

        Course course1 = new Course();
        course1.setTitle("Spring Boot in Java");
        Course course2 = new Course();
        course2.setTitle("Hibernate");
        Course course3 = new Course();
        course3.setTitle("JavaScript Basics");

        instructor.add(course1);
        instructor.add(course2);
        instructor.add(course3);

        instructorRepo.save(instructor);
        System.out.println("Saved Instructor and Course into database");
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////
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
        passport.setPerson(person);

//        passportService.save(passport); // Not required in CascadeType.ALL
        personService.save(person);

        System.out.println("Person have been saved");
    }

    public void deletePerson(PersonService personService, PassportService passportService) {
        Integer id = 4;
        personService.delete(id);
        System.out.printf("Person with id %d has been deleted%n", id);
    }

    public void printPassport(PassportService passportService) {
        Passport passport = passportService.getPassport(1);
        System.out.println(passport.getId() + " " + passport.getPassportNo());

        System.out.println("--------------------------------------------------");
        System.out.println(passport.getPerson());
    }


}
