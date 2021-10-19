package com.example.kino.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor

@Entity
@Table(name = "theater")
public class Theater {

    @Id
    @Column(name = "theater_id")
    private Long theaterId;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "movie_movie_id")
    private Movie movie;

}
