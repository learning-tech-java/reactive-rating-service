package com.example.reactiveratingservice.request.create;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateRating(

        @NotBlank
        String productCode,

        @NotNull
        @Min(1)
        @Max(5)
        Integer value
) {
}
