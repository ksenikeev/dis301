package ru.itis.dis301.lab2_06.repository;

import org.springframework.data.repository.CrudRepository;
import ru.itis.dis301.lab2_06.model.Film;

public interface FilmRepository
        extends CrudRepository<Film, Long> {
}
