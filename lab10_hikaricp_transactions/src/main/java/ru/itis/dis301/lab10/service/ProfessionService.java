package ru.itis.dis301.lab10.service;

import ru.itis.dis301.lab10.model.Client;
import ru.itis.dis301.lab10.model.Profession;
import ru.itis.dis301.lab10.repository.ClientRepository;
import ru.itis.dis301.lab10.repository.ProfessionRepository;

import java.util.ArrayList;
import java.util.List;

public class ProfessionService {

    private ProfessionRepository repository;

    public ProfessionService() {
        repository = new ProfessionRepository();
    }

    public List<Profession> findAll() {
        return repository.findAll();
    }

    public List<Profession> findByName(String name, int limit, int offset) {
        return repository.findByName(name, limit, offset);
    }

    public Integer countResults(String name) {
        return repository.countResults(name);
    }
}
