package com.example.kino.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter@ToString
@RequiredArgsConstructor

@Entity
@Table(name = "showing")
public class Showing implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "showing_id")
    private Long showingId;
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "showing_seq_gen")
    @SequenceGenerator(name = "showing_seq_gen", sequenceName = "showing_seq_gen", allocationSize = 1)

    @OneToOne
    @JoinColumn
    private Movie movie;

    @OneToOne
    @JoinColumn(name = "theater")
    private Theater theater;

    @Column(name = "showing_price")
    private int showingPrice;

}
