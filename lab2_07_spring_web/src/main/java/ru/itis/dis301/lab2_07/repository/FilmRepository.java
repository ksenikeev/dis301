package ru.itis.dis301.lab2_07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.itis.dis301.lab2_07.model.Film;
import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {

    //@Query("select f from Film f where name = :name")
    List<Film> findByName(String name);
}
