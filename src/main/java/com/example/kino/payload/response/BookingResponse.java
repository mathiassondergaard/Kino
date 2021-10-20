package com.example.kino.payload.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class BookingResponse {

    private Long bookingId;
    private int nrOfAssignedSeats;
    private String theater;
    private String movieName;
    private LocalDate showingDate;
    private String showingTime;

    public BookingResponse(Long bookingId, int nrOfAssignedSeats, String theater, String movieName, LocalDate showingDate, String showingTime) {
        this.bookingId = bookingId;
        this.nrOfAssignedSeats = nrOfAssignedSeats;
        this.theater = theater;
        this.movieName = movieName;
        this.showingDate = showingDate;
        this.showingTime = showingTime;
    }
}
