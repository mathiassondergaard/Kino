package com.example.kino.payload.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@ToString
public class BookingRequest {

    @NotBlank
    private int nrOfAssignedSeats;
    @NotBlank
    private String theater;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate showingDate;
    @NotBlank
    private String showingTime;
    @NotBlank
    private Long movieId;

    public BookingRequest(int nrOfAssignedSeats, String theater, LocalDate showingDate, String showingTime, Long movieId) {
        this.nrOfAssignedSeats = nrOfAssignedSeats;
        this.theater = theater;
        this.showingDate = showingDate;
        this.showingTime = showingTime;
        this.movieId = movieId;
    }
}
