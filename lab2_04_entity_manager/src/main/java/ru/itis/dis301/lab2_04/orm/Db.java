package ru.itis.dis301.lab2_04.orm;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Db {
    private DbConfig dbconfig;

    @Override
    public String toString() {
        return "Db{" +
                "dbconfig=" + dbconfig +
                '}';
    }
}