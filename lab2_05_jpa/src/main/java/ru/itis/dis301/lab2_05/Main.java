package ru.itis.dis301.lab2_05;


import jakarta.persistence.*;
import ru.itis.dis301.lab2_05.model.Actor;
import ru.itis.dis301.lab2_05.model.Genre;

import java.util.HashSet;
import java.util.List;
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

        //removeActor(4l, entityManager);

        renameActor(3l, "Gerard Depardieu", entityManager);

        //findAllNative(entityManager).forEach(System.out::println);

/*
        entityManager.getTransaction().begin();
        Actor actor = findByIdEager(1l, entityManager);
        Set<Genre> genres = actor.getGenres();
        System.out.println(actor);
        genres.forEach(System.out::println);
        actor.setName("Евгений Леонов");
        entityManager.getTransaction().commit();
*/

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

    private static List<Actor> findAll(EntityManager em) {
        Query query = em.createQuery("select a from Actor a ");

        List<Actor> result = query.getResultList();
        return result;
    }

    private static Actor findById(Long id, EntityManager em) {
        Query query = em.createQuery("select a from Actor a where id = :id ");
        query.setParameter("id", id);
        try {
            Actor result = (Actor) query.getSingleResult();
            return result;
        } catch (PersistenceException e) {
            return null;
        }

    }

    private static Actor findByIdEager(Long id, EntityManager em) {
        Query query = em.createQuery("select a from Actor a LEFT JOIN FETCH a.genres where a.id = :id ");
        query.setParameter("id", id);
        try {
            Actor result = (Actor) query.getSingleResult();
            return result;
        } catch (PersistenceException e) {
            return null;
        }

    }

    private static List<Actor> findAllNative(EntityManager em) {
        Query query = em.createNativeQuery("select * from actor natural join person ", Actor.class);
        List<Actor> result = query.getResultList();
        return result;
    }
    private static void renameActor(Long id, String newName, EntityManager em) {
        em.getTransaction().begin();
        Query query = em.createQuery("update Actor a set name = :name where id = :id ");
        query.setParameter("name", newName);
        query.setParameter("id", id);
        query.executeUpdate();
        em.getTransaction().commit();
    }
}
