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
    public Mono<Rating> getRatingByProductCode(String productCode) {

        return ratingRepository.findByProductCode(productCode)
                .switchIfEmpty(
                        Mono.error(new RatingNotFoundException(productCode))
                )
                .map(ratingMapper::toRating);

    }

}
