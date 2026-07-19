package com.example.reactiveratingservice.controller;

import com.example.reactiveratingservice.common.AvgRating;
import com.example.reactiveratingservice.request.create.CreateRatingRequest;
import com.example.reactiveratingservice.response.create.CreatedRating;
import com.example.reactiveratingservice.service.RatingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CreatedRating> create(@Valid @RequestBody CreateRatingRequest request) {
        return ratingService.create(request);
    }

    @GetMapping("/{productCode}")
    public Mono<AvgRating> getAvgRatingByProductCode(@PathVariable String productCode) {
        return ratingService.getAvgRatingByProductCode(productCode);
    }
}
