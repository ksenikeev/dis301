package ru.itis.dis301.lab2_07.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dis301.lab2_07.model.Genre;
import ru.itis.dis301.lab2_07.repository.GenreRepository;

@Service
public class GenreService implements IGenreService {

    @Autowired
    private GenreRepository genreRepository;

    public Iterable<Genre> findAll() {
        return genreRepository.findAll();
    }

    public Genre getRefernceById(Long id) {
        return genreRepository.getReferenceById(id);
    }
}
