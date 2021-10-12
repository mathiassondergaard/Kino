package com.example.kino.service;

import com.example.kino.model.Movie;
import com.example.kino.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.NoResultException;

public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(()-> new NoResultException());
    }
}
