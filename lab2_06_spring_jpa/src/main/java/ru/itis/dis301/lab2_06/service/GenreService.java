package ru.itis.dis301.lab2_06.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dis301.lab2_06.model.Genre;
import ru.itis.dis301.lab2_06.repository.GenreRepository;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Transactional
    public Genre save(Genre genre) {


        return genreRepository.save(genre);
    }

}
