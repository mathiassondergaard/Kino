package com.example.kino.payload.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@RequiredArgsConstructor
public class BookingRequest {

    @NotBlank
    int nrOfAssignedSeats;
    @NotBlank
    private String theater;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate showingDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh-MM")
    private LocalTime showingTime;
    @NotBlank
    private Long movieId;

    public BookingRequest(int nrOfAssignedSeats, String theater, LocalDate showingDate, LocalTime showingTime, Long movieId) {
        this.nrOfAssignedSeats = nrOfAssignedSeats;
        this.theater = theater;
        this.showingDate = showingDate;
        this.showingTime = showingTime;
        this.movieId = movieId;
    }
}
