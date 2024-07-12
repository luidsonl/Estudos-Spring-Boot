package com.estudos.runnerz.run;

import java.time.LocalDateTime;

public record Run (
    Integer id,
    String title,
    Coordinate startPoint,
    Coordinate endPoint,
    LocalDateTime startTime,
    LocalDateTime endTime
){ }

