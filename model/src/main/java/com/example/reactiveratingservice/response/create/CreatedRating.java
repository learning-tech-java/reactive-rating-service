package com.example.reactiveratingservice.response.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreatedRating(

        @NotBlank
        String productCode,

        @NotNull
        Integer value
) {
}
