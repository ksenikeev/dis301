package ru.itis.dis301.lab2_04.model;

import lombok.Getter;
import lombok.Setter;
import ru.itis.dis301.lab2_04.annotation.Entity;

@Getter
@Setter
@Entity
public class Genre {
    private Integer id;
    private String name;
}
