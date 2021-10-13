package com.example.kino.controller;


import com.example.kino.model.Movie;
import com.example.kino.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@CrossOrigin(value = "*")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/getMovie/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        Movie movie = movieService.findById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping(value = "/createMovie", consumes = "application/json")
    public ResponseEntity<Movie> newMovie(@RequestBody Movie movie) throws URISyntaxException {
        Movie result = movieService.saveMovie(movie);
        return ResponseEntity.created(new URI("/getMovie/" + result.getMovieID())).body((result));
    }

    @PutMapping("/updateMovie/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        Movie tmpMovie = movieService.updateMovie(movie, id);
        return ResponseEntity.ok().body(tmpMovie);
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok().build();
    }

}
