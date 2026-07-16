package com.example.reactiveratingservice.service;

import com.example.reactiveratingservice.exception.RatingNotFoundException;
import com.example.reactiveratingservice.mapper.RatingMapper;
import com.example.reactiveratingservice.repository.RatingRepository;
import com.example.reactiveratingservice.common.Rating;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;

    @Override
    public Mono<Rating> getRatingByCode(String code) {

        return ratingRepository.findByCode(code)
                .switchIfEmpty(
                        Mono.error(new RatingNotFoundException(code))
                )
                .map(ratingMapper::toRating);

    }

}
