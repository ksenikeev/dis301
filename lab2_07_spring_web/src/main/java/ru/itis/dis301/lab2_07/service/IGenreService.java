package ru.itis.dis301.lab2_07.service;

import ru.itis.dis301.lab2_07.model.Genre;

public interface IGenreService {
    Iterable<Genre> findAll();
    Genre getRefernceById(Long id);
}
