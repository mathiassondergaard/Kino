package com.example.kino.service;

import java.time.LocalDate;

public abstract class Utilities {
    public boolean dateChecker(LocalDate startDate, LocalDate endDate) {return endDate.isBefore(startDate);}
}
