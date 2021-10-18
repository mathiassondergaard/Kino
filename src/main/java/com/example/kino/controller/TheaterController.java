package com.example.kino.controller;


import com.example.kino.model.Theater;
import com.example.kino.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//TODO: Fix this controller - Show current and maybe upcoming showings?

@Controller
@CrossOrigin(origins = "http://localhost:63342")
public class TheaterController {

    private TheaterService theaterService;

    @Autowired
    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping("/GetTheater/{id}")
    public ResponseEntity<Theater> getTheater(@PathVariable long id) {
        Theater theater = theaterService.findById(id);
        return new ResponseEntity<>(theater, HttpStatus.OK);
    }



}
