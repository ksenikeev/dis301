package ru.itis.dis301.lab2_06.model;

import jakarta.persistence.*;
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
