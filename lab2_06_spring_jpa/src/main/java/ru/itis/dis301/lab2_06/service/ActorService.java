package ru.itis.dis301.lab2_06.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dis301.lab2_06.model.Actor;
import ru.itis.dis301.lab2_06.repository.ActorRepository;
import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> findAll() {
        return actorRepository.findAll();
    }
}
