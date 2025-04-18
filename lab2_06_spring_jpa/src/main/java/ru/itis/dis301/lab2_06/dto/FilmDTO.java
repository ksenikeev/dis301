package ru.itis.dis301.lab2_06.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter@Setter@AllArgsConstructor
public class FilmDTO {

    private Long id;

    private String name;

    private Date productionDate;
}
