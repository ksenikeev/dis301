package ru.itis.dis301.lab2_07.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
