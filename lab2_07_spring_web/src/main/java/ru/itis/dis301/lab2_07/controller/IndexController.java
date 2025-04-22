package ru.itis.dis301.lab2_07.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.dis301.lab2_07.model.Film;
import ru.itis.dis301.lab2_07.model.Genre;
import ru.itis.dis301.lab2_07.service.FilmService;
import ru.itis.dis301.lab2_07.service.GenreService;

import java.util.List;

@Controller
public class IndexController {

    public IndexController(FilmService filmService, GenreService genreService ) {
        this.filmService = filmService;
        this.genreService = genreService;
    }

    private FilmService filmService;
    private GenreService genreService;

    @GetMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {

        List<Film> films = filmService.findByName("Кин-дза-дза");
        model.addAttribute("film", films.get(0));

        Iterable<Genre> genres = genreService.findAll();
        model.addAttribute("genres", genres);

        return "index";
    }
}
