package ru.itis.dis301.lab2_07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.dis301.lab2_07.model.Film;
import ru.itis.dis301.lab2_07.service.FilmService;

import java.util.List;

@Controller
public class IndexController {

    public IndexController(FilmService filmService) {
        this.filmService = filmService;
    }

    private FilmService filmService;

    @GetMapping("/index")
    public String index(Model model) {

        List<Film> films = filmService.findByName("Кин-дза-дза");

        if (films != null) {
            System.out.println(films.get(0));
            model.addAttribute("film", films.get(0));
        } else {
            System.out.println("не нашли");
        }

        return "index";
    }
}
