package ru.itis.dis301.lab2_07.service;

import org.springframework.stereotype.Service;
import ru.itis.dis301.lab2_07.model.Film;
import ru.itis.dis301.lab2_07.repository.FilmRepository;

import java.util.List;

@Service
public class FilmService {

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    private FilmRepository filmRepository;

    public List<Film> findByName(String name) {
        return filmRepository.findByName(name);
    }
}
