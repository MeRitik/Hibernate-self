package com.hib.oneToMany.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    @ToString.Exclude
    @OneToMany(mappedBy = "instructor", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                        CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private List<Course> courses; // LAZY is default in @OneToMany


    public void add(Course course) {
        if(courses == null) {
            courses = new ArrayList<>();
        }

        course.setInstructor(this);
        courses.add(course);
    }
}
