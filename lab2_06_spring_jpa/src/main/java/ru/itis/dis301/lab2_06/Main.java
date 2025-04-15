package ru.itis.dis301.lab2_06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.dis301.lab2_06.config.Config;
import ru.itis.dis301.lab2_06.model.Genre;
import ru.itis.dis301.lab2_06.repository.GenreRepository;
import ru.itis.dis301.lab2_06.service.ActorService;
import ru.itis.dis301.lab2_06.service.GenreService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        ActorService actorService = context.getBean(ActorService.class);

        actorService.findAll().forEach(System.out::println);

        GenreRepository genreRepository =
                context.getBean(GenreRepository.class);

        genreRepository.findAll().forEach(System.out::println);

        System.out.println("id = 1: " + genreRepository.getByIdNative(1l));

/*
        GenreService genreService = context.getBean(GenreService.class);

        Genre genre = new Genre();
        genre.setName("Ужасы");

        genreService.save(genre);
*/

    }
}
