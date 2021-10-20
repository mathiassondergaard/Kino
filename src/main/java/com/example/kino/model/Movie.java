package com.example.kino.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "movie")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq_gen")
    @SequenceGenerator(name = "movie_seq_gen", sequenceName = "movie_seq_gen", allocationSize = 1)
    private Long movieID;

    @Column(name = "movie_title")
    private String movieTitle;

    @Column(name = "movie_duration")
    private String movieDuration;

    @Column(name = "movie_age_restriction")
    private String movieAgeRestriction;

    @Column(name = "movie_category")
    @Enumerated(EnumType.STRING)
    @Getter
    private MovieCategory movieCategory;

    @Column(name = "movie_actors")
    private String movieActors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(movieID, movie.movieID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieID);
    }
}
