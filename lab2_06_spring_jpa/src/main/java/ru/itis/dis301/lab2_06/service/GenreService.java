package ru.itis.dis301.lab2_06.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dis301.lab2_06.model.Genre;
import ru.itis.dis301.lab2_06.repository.GenreRepository;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public Iterable<Genre> findAll() {
        return genreRepository.findAll();
    }

    public Genre find(Long id) {
        return genreRepository.getGenre(id);
    }
}
