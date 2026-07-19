package com.example.reactiveratingservice.request.create;

import jakarta.validation.Valid;
import lombok.Getter;

@Getter
public class CreateRatingRequest {

    @Valid
    private CreateRating rating;
}
