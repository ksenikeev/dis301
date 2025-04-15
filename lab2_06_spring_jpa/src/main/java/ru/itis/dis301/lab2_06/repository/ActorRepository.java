package ru.itis.dis301.lab2_06.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import ru.itis.dis301.lab2_06.model.Actor;

import java.util.List;

@Repository
public class ActorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Actor> findAll() {
        Query query = entityManager.createQuery("select a from Actor a");
        return query.getResultList();
    }
}
