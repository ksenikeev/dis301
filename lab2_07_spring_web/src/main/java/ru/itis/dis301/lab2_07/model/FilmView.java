package ru.itis.dis301.lab2_07.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.util.Date;

@Getter@Setter
@Entity
@Immutable
public class FilmView {

    @Id
    private Long id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date productionDate;
}
