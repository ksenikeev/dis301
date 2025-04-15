package ru.itis.dis301.lab2_06.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itis.dis301.lab2_06.model.Genre;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {

    @Query("select g from Genre g where g.id = :id ")
    Genre getGenre(@Param("id") Long id);
}
