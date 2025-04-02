package ru.itis.dis301.lab2_04.model;

import lombok.Getter;
import lombok.Setter;
import ru.itis.dis301.lab2_04.annotation.Entity;
import ru.itis.dis301.lab2_04.annotation.ManyToOne;

@Getter
@Setter
@Entity
public class Musician {
    private Integer id;
    private String name;
    @ManyToOne
    private Country country;
}
