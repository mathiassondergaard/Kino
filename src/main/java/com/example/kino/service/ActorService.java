package com.example.kino.service;

import com.example.kino.model.Actor;
import com.example.kino.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class ActorService {

    private ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Actor findActorById(Long id) {
        return actorRepository.findById(id).orElseThrow(() -> new NoResultException("Actor with id: " + id + " does not exist!"));
    }

    public List<Actor> findAllActors() {
        return actorRepository.findAll();
    }

    public void deleteActor(Long id) {
        Actor actorToDelete = actorRepository.findById(id).orElseThrow(() -> new NoResultException("Actor with id: " + id + " does not exist!"));
        actorRepository.delete(actorToDelete);
    }

    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }
}
