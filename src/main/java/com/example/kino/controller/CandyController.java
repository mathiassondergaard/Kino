package com.example.kino.controller;

import com.example.kino.model.Candy;
import com.example.kino.service.CandyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class CandyController {

    private CandyService candyService;

    @Autowired
    public CandyController(CandyService candyService){
        this.candyService = candyService;
    }

    @GetMapping("/candy/{id}")
    public ResponseEntity<Candy> candy(@PathVariable Long id){
        Candy candy = candyService.findById(id);
        return new ResponseEntity<>(candy, HttpStatus.OK);
    }

    @GetMapping("/showAllCandy")
    public List<Candy> allCandy(){
        return candyService.findAll();
    }

    @PostMapping("/candy")
    public ResponseEntity<Candy> newCandy(@RequestBody Candy candy) throws URISyntaxException{
        Candy result = candyService.saveCandy(candy);
        return ResponseEntity.created(new URI("/candy/" + result.getCandyID())).body(result);
    }

    @PutMapping("/candy/{id}")
    public ResponseEntity<Candy> updateCandy(@PathVariable Long id, @RequestBody Candy candy){
        Candy tmpCandy = candyService.updateCandy(candy, id);
        return ResponseEntity.ok().body(tmpCandy);
    }

    @DeleteMapping("/candy/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id){
        candyService.deleteCandy(id);
        return ResponseEntity.ok().build();
    }

}
