package com.ulas.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PenaltySystem {
    public static double calculatePenalty(LocalDate dueDate, LocalDate returnDate) {
        long daysOverdue = ChronoUnit.DAYS.between(dueDate, returnDate);
        if (daysOverdue > 0) {
            return daysOverdue * 0.5; // Gün başına 0.5 birim ceza
        }
        return 0;
    }
}
