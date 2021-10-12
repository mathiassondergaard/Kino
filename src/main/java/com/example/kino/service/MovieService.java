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
}
