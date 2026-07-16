package com.example.reactiveratingservice.controller;

import com.example.reactiveratingservice.common.Rating;
import com.example.reactiveratingservice.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @GetMapping
    public Mono<Rating> getRatingByCode(@PathVariable String code) {

        return ratingService.getRatingByCode(code);

    }

}
