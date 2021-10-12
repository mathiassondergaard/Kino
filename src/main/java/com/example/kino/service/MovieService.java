package com.example.kino.service;

import com.example.kino.model.Movie;
import com.example.kino.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(()-> new NoResultException());
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie, Long id) {
        Movie movieData = findById(id);
        movieData.setMovieID(movie.getMovieID());
        movieData.setMovieTitle(movie.getMovieTitle());
        movieData.setMovieDuration(movie.getMovieDuration());
        movieData.setMovieCategory(movie.getMovieCategory());
        movieData.setMovieAgeRestriction(movie.getMovieAgeRestriction());

        return movieRepository.save(movieData);

    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
