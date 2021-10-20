package com.example.kino.payload.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@RequiredArgsConstructor
public class BookingRequest {


    @NotBlank
    int nrOfAssignedSeats;
    @NotBlank
    private String theater;
    @NotBlank
    Long movieId;

    public BookingRequest(int nrOfAssignedSeats, String theater, Long movieId) {
        this.nrOfAssignedSeats = nrOfAssignedSeats;
        this.theater = theater;
        this.movieId = movieId;
    }
}
