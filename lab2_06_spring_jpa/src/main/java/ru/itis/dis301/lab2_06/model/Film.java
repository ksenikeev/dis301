package ru.itis.dis301.lab2_06.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;
import java.util.Date;

@Getter@Setter
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date productionDate;

    @ManyToOne
    private Genre genre;

    @ManyToMany
    private Collection<Actor> actors;

    public String toString() {
        return "id: " + id + ", name: " + name;
    }
}
