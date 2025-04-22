package ru.itis.dis301.lab2_07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.itis.dis301.lab2_07.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
