package com.example.kino.controller;

import com.example.kino.model.Actor;
import com.example.kino.model.Movie;
import com.example.kino.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class ActorController {

    private ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/getActor/{id}")
    public ResponseEntity<Actor> getActor(@PathVariable Long id) {
        Actor actor = actorService.findActorById(id);
        return new ResponseEntity<>(actor, HttpStatus.OK);
    }

    @Transactional
    @Modifying
    @PostMapping(value = "/createActor", consumes = "application/json")
    public ResponseEntity<Actor> createActor(@RequestBody Actor movie) throws URISyntaxException {
        Actor result = actorService.createActor(movie);
        return ResponseEntity.created(new URI("/getActor/" + result.getActorID())).body((result));
    }

    @PutMapping("/actors")
    public ResponseEntity<List<Actor>> findAllActors() {
        List<Actor> actorList = actorService.findAllActors();
        return new ResponseEntity<>(actorList, HttpStatus.OK);
    }

    @DeleteMapping("/actor/delete/{id}")
    public ResponseEntity<?> deleteActor(@PathVariable Long id) {
        actorService.deleteActor(id);
        return ResponseEntity.ok().build();
    }
}
