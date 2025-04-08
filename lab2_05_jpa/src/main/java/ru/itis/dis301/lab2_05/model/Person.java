package ru.itis.dis301.lab2_05.model;


import jakarta.persistence.*;

import static jakarta.persistence.InheritanceType.JOINED;

@Entity
@Inheritance(strategy = JOINED)
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Long id;

    protected String name;
}
