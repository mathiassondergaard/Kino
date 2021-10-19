package com.example.kino.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
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
}
