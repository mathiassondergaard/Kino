package com.example.kino.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "booking")
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "booking_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_seq_gen")
    @SequenceGenerator(name = "booking_seq_gen", sequenceName = "booking_seq_gen", allocationSize = 1)
    private Long bookingId;

    @Column(name = "booking_seats")
    private int nrOfAssignedSeats;

    @Column(name = "booking_theater")
    private String theater;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(name = "showing_date")
    private LocalDate showingDate;

    @Column(name = "showing_time")
    private String showingTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookingId, booking.bookingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId);
    }


    //For testing purposes
    public Booking(Long bookingId, LocalDate showingDate) {
        this.bookingId = bookingId;
        this.showingDate = showingDate;
    }
    //For testing purposes
    public Booking(Long bookingId, LocalDate showingDate, int nrOfAssignedSeats, String theater) {
        this.bookingId = bookingId;
        this.showingDate = showingDate;
        this.nrOfAssignedSeats = nrOfAssignedSeats;
        this.theater = theater;
    }

}
