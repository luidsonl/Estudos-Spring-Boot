package com.estudos.runnerz.run;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record Run (
    Integer id,
    @NotEmpty
    String title,
    Coordinate startPoint,
    Coordinate endPoint,
    LocalDateTime startTime,
    LocalDateTime endTime
){
    public Run {
        if (endTime != null && !endTime.isAfter(startTime)) {
            throw new IllegalArgumentException("End time must be after start time");
        }
    }
}

