package ru.itis.dis301.lab2_06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.dis301.lab2_06.config.Config;
import ru.itis.dis301.lab2_06.model.Actor;
import ru.itis.dis301.lab2_06.service.ActorService;
import ru.itis.dis301.lab2_06.service.GenreService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        ActorService actorService = context.getBean(ActorService.class);

        Actor actor = new Actor();
        actor.setName("Клинт Иствуд");

        //actorService.save(actor);

        GenreService genreService = context.getBean(GenreService.class);

        genreService.findAll().forEach(System.out::println);
        System.out.println(genreService.find(1L));
    }
}
