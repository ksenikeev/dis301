package ru.itis.dis301.lab2_05;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ru.itis.dis301.lab2_05.model.Actor;
import ru.itis.dis301.lab2_05.model.Genre;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("lab2_05");

        EntityManager entityManager = emf.createEntityManager();

        //addGenre("Фантастика", entityManager);

/*
        Genre genre1 = getGenre(1L, entityManager);
        Genre genre2 = getGenre(2L, entityManager);
        Set<Genre> genres = new HashSet<>();
        genres.add(genre1);
        genres.add(genre2);
*/

        //addActor("Леонов", genres, entityManager);

/*
        Genre genre1 = getGenreReference(1L, entityManager);
        Genre genre2 = getGenreReference(4L, entityManager);
        Set<Genre> genres = new HashSet<>();
        genres.add(genre1);
        genres.add(genre2);

        addActor("Дикаприо ", genres, entityManager);
*/

        removeActor(4l, entityManager);

        entityManager.close();
        emf.close();
    }

    private static Genre getGenre(Long id, EntityManager em) {
        return em.find(Genre.class, id);
    }

    private static void addGenre(String name, EntityManager em) {
        Genre genre = new Genre();
        genre.setName(name);

        em.getTransaction().begin();
        em.persist(genre);
        em.getTransaction().commit();
    }

    private static void addActor(String name, Set<Genre> genres, EntityManager em) {
        Actor actor = new Actor();
        actor.setName(name);
        actor.setGenres(genres);
        em.getTransaction().begin();
        em.persist(actor);
        em.getTransaction().commit();
    }

    private static Genre getGenreReference(Long id, EntityManager em) {
        return em.getReference(Genre.class, id);
    }

    private static void removeActor(Long id, EntityManager em) {
        em.getTransaction().begin();
        Actor actor = em.getReference(Actor.class, id);
        em.remove(actor);
        em.getTransaction().commit();
    }

}
