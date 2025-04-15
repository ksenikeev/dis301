package ru.itis.dis301.lab2_06.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dis301.lab2_06.model.Actor;
import ru.itis.dis301.lab2_06.repository.ActorRepository;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Transactional
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }


}
