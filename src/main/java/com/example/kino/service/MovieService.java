package com.example.kino.service;


import com.example.kino.model.Movie;
import com.example.kino.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
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


    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @Transactional
    @Modifying
    public Movie saveMovie(Movie movie) {
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

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
