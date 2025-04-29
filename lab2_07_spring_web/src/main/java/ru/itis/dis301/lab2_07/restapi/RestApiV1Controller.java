package ru.itis.dis301.lab2_07.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.itis.dis301.lab2_07.dto.FilmDTO;
import ru.itis.dis301.lab2_07.model.Film;
import ru.itis.dis301.lab2_07.service.FilmService;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/filmservice/v1")
public class RestApiV1Controller {

    @Autowired
    private FilmService filmService;

    @PostMapping("/film")
    @ResponseStatus(HttpStatus.CREATED)
    public FilmDTO addFilm(@RequestBody FilmDTO film) {
        return filmService.save(film);
    }

    @PutMapping("/film/{idFilm}")
    public FilmDTO addFilm(@RequestBody FilmDTO film, @PathVariable Long idFilm) {
        return filmService.update(film, idFilm);
    }

    @GetMapping("/film/{idFilm}")
    public FilmDTO getFilm(@PathVariable Long idFilm) {
        Film f = filmService.findById(idFilm)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Не удалось найти фильм"));
        return new FilmDTO(f.getId(), f.getName(), f.getGenre().getId());
    }

    @DeleteMapping("/film/{idFilm}")
    public FilmDTO deleteFilm(@PathVariable Long idFilm) {
        Film f = filmService.findById(idFilm).get();
        f.setDeleted(true);
        f = filmService.save(f);
        return new FilmDTO(f.getId(), f.getName(), f.getGenre().getId());
    }
}
