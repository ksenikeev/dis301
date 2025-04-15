package ru.itis.dis301.lab2_06.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.dis301.lab2_06.model.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {

    @Query("select g from Genre g where id = :id ")
    Genre getById(@Param("id") Long id);

    @Query(value = "select * from genre where id = :id ",
            nativeQuery = true)
    Genre getByIdNative(@Param("id") Long id);
}
