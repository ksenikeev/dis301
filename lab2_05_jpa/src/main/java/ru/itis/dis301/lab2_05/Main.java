package ru.itis.dis301.lab2_05;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("lab2_05");

        EntityManager entityManager = emf.createEntityManager();

        entityManager.close();
        emf.close();
    }
}
