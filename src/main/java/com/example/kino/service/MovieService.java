package com.example.kino.service;

import com.example.kino.model.Actor;
import com.example.kino.model.Movie;
import com.example.kino.repository.ActorRepository;
import com.example.kino.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepository;


    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(()-> new NoResultException("Movie with id: " + id + " does not exist!"));
    }

    @Transactional
    @Modifying
    public Movie saveMovie(Movie movie) {
        List<Actor> actors = movie.getActors();
        for (int i = 0; i < actors.size(); i++) {
            actors.get(i).getMovie().setMovieID(movie.getMovieID());
        }
        /*
        List<Actor> actors = movie.getActors();
        for (int i = 0; i < actors.size(); i++) {
            actors.get(i).setMovie(movie);
            List<Actor> foundActors = new ArrayList<>();
            foundActors.add(actorRepository.findActorByActorName(actors.get(i).getActorName()));
            movie.setActors(foundActors);
        }
        */
        return movieRepository.save(movie);
    }

    @Transactional
    @Modifying
    public Movie updateMovie(Movie movie, Long id) {
        Movie movieData = movieRepository.findById(id).orElseThrow(()-> new NoResultException("Movie with id: " + id + " does not exist!"));
        movieData.setMovieID(movie.getMovieID());
        movieData.setMovieTitle(movie.getMovieTitle());
        movieData.setMovieDuration(movie.getMovieDuration());
        movieData.setMovieCategory(movie.getMovieCategory());
        movieData.setMovieAgeRestriction(movie.getMovieAgeRestriction());
        return movieRepository.save(movieData);
    }

    @Transactional
    @Modifying
    public Movie addOrEditActorsToMovie(List<Actor> actorList, Long id) {
        Movie movieData = movieRepository.findById(id).orElseThrow(()-> new NoResultException("Movie with id: " + id + " does not exist!"));
        movieData.setActors(actorList);
        return movieRepository.save(movieData);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
