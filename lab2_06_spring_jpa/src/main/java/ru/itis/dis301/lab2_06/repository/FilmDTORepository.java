package ru.itis.dis301.lab2_06.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.itis.dis301.lab2_06.dto.FilmDTO;
import ru.itis.dis301.lab2_06.model.Film;

import java.util.Collection;

public interface FilmDTORepository extends CrudRepository<Film, Long> {

    /*
        Film -> id, name, productionDate
     */
    @Query("select new ru.itis.dis301.lab2_06.dto.FilmDTO(id, name, productionDate) from Film f")
    Collection<FilmDTO> findAllFilm();
}
