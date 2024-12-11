package ru.itis.dis301.lab10.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.itis.dis301.lab10.model.Profession;

import java.util.ArrayList;
import java.util.List;

public class ProfessionRepository {

    final static Logger logger = LogManager.getLogger(ClientRepository.class);

    private DbWork db = DbWork.getInstance();

    public List<Profession> findAll() {
        return new ArrayList<>();
    }

    public List<Profession> findByName(String name, int limit, int offset) {
        return new ArrayList<>();
    }

    public Integer countResults(String name) {
        return 100;
    }
}
