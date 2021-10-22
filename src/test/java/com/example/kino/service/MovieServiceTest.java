package com.example.kino.service;

import com.example.kino.model.Movie;
import com.example.kino.repository.MovieRepository;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import javax.persistence.NoResultException;
import java.util.Optional;


class MovieServiceTest {

    private AutoCloseable autoCloseable;
    @InjectMocks
    private MovieService movieService;
    @Mock
    private MovieRepository movieRepository;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @After
    void releaseMocks() throws Exception {
        autoCloseable.close();
    }

    @Test
    void findById() {
        Mockito.when(this.movieRepository.findById(1L)).thenReturn(Optional.of(new Movie(1L, "Avatar")));
        Movie movie = this.movieRepository.findById(1L).orElseThrow(() -> new NoResultException("Unable to find movie by id"));
        Assertions.assertEquals("Avatar", movie.getMovieTitle());
    }

    @Test
    void findAllMovies() {

    }
}