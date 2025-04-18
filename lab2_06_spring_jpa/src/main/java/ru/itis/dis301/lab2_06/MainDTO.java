package ru.itis.dis301.lab2_06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.dis301.lab2_06.config.Config;
import ru.itis.dis301.lab2_06.repository.FilmDTORepository;

public class MainDTO {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        FilmDTORepository filmRepository =
                context.getBean(FilmDTORepository.class);

        filmRepository.findAllFilm().forEach(System.out::println);
    }
}
