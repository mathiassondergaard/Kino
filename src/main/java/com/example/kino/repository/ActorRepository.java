package com.example.kino.repository;

import com.example.kino.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    Actor findActorByActorName(String actorName);

}
