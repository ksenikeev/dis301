package ru.itis.dis301.lab2_07.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.dis301.lab2_07.dto.FilmDTO;
import ru.itis.dis301.lab2_07.model.Film;
import ru.itis.dis301.lab2_07.model.Genre;
import ru.itis.dis301.lab2_07.service.FilmService;
import ru.itis.dis301.lab2_07.service.GenreService;
import ru.itis.dis301.lab2_07.service.IGenreService;

import java.util.List;

@Controller
public class FilmController {

    Logger logger = LoggerFactory.getLogger(FilmController.class);

    public FilmController(FilmService filmService, IGenreService genreService ) {
        this.filmService = filmService;
        this.genreService = genreService;
    }

    private FilmService filmService;
    private IGenreService genreService;


    @RequestMapping("/films/add")
    public String addNewFilm(@RequestParam(value = "name") String name,
                             @RequestParam("genre") Long genreId, Model model) {

        logger.debug("Получили параметры " + name + " " + genreId);

        Film film = filmService.saveFromParams(name, genreId);

        model.addAttribute("film", film);

        Iterable<Genre> genres = genreService.findAll();
        model.addAttribute("genres", genres);

        return "index";
    }

    @RequestMapping("films/addto")
    public String addNewFilm(FilmDTO filmDTO, Model model) {

        logger.debug("Получили параметры " + filmDTO.name() + " " + filmDTO.genre());

        Film film = filmService.saveFromParams(filmDTO.name(), filmDTO.genre());

        model.addAttribute("film", film);

        Iterable<Genre> genres = genreService.findAll();
        model.addAttribute("genres", genres);

        return "index";
    }
}
