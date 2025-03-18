package com.hib.oneToOne.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;

    /** 1. (cascade = CascadeType.ALL) Applies all operations (PERSIST, MERGE, REMOVE, REFRESH, DETACH).
     *  2. (cascade = CascadeType.None) // Default is CascadeType.NONE
     *  3. (cascade = {CascadeType.DETACH, CascadeType.MERGE,
     *              CascadeType.PERSIST, CascadeType.REFRESH})
     *  doesn't delete enable selective cascading
     */

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
                         CascadeType.PERSIST, CascadeType.REFRESH})
    private Passport passport;
}
