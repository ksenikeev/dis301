package ru.itis.dis301.lab2_07.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.InheritanceType.JOINED;

@Getter@Setter
@Entity
@Inheritance(strategy = JOINED)
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Long id;

    protected String name;
}
