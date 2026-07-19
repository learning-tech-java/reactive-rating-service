package com.example.reactiveratingservice.common;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record AvgRating(

        @NotNull
        @DecimalMin("0.00")
        @DecimalMax("5.00")
        @Digits(integer = 1, fraction = 2)
        BigDecimal value
) {
}
