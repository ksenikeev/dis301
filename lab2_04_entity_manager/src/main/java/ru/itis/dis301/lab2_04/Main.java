package ru.itis.dis301.lab2_04;

import ru.itis.dis301.lab2_04.orm.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = new EntityManagerFactory();
        emf.close();
    }
}
