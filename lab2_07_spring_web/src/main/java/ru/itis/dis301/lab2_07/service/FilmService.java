package ru.itis.dis301.lab2_07.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.dis301.lab2_07.model.Film;
import ru.itis.dis301.lab2_07.repository.FilmRepository;
import ru.itis.dis301.lab2_07.repository.GenreRepository;

import java.util.List;

@Service
public class FilmService {

    public FilmService(FilmRepository filmRepository, GenreRepository genreRepository) {
        this.filmRepository = filmRepository;
        this.genreRepository = genreRepository;
    }

    private FilmRepository filmRepository;
    private GenreRepository genreRepository;

    public List<Film> findByName(String name) {
        return filmRepository.findByName(name);
    }

    public Film save(Film film) {
        return filmRepository.save(film);
    }

    @Transactional
    public Film saveFromParams(String name, Long genreId) {
        Film film = new Film();
        film.setName(name);
        if (genreId != null) {
            film.setGenre(genreRepository.getReferenceById(genreId));
        }
        return filmRepository.save(film);
    }
}
