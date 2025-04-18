package ru.itis.dis301.lab2_05.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter@Setter
@Entity
public class Actor extends Person {

    //@ManyToMany(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
    @ManyToMany(cascade=CascadeType.PERSIST)
    Set<Genre> genres;

    @Override
    public String toString() {
        return "Actor{name='" + name + '}';
    }
}
