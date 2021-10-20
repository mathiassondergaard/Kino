package com.example.kino.repository;

import com.example.kino.model.Movie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("Movies")
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {




}

