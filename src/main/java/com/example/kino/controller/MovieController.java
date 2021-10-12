package com.example.kino.controller;


import com.example.kino.model.Movie;
import com.example.kino.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/getMovie/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
    Movie movie = movieService.findById(id);
    return new ResponseEntity<> (movie, HttpStatus.OK);

    }

}
