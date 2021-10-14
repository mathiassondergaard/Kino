package com.example.kino.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "booking_date")
    private Date date;

    @Column(name = "booking_time")
    private Time time;

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
