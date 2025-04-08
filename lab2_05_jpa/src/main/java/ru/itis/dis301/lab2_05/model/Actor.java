package ru.itis.dis301.lab2_05.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter@Setter
@Entity
public class Actor extends Person {
    @ManyToMany
    Set<Genre> genres;
}
