package com.example.reactiveratingservice.service;

import com.example.reactiveproductservice.exception.ProductNotFoundException;
import com.example.reactiveproductservice.service.ProductService;
import com.example.reactiveratingservice.mapper.RatingMapper;
import com.example.reactiveratingservice.repository.RatingRepository;
import com.example.reactiveratingservice.common.AvgRating;
import com.example.reactiveratingservice.request.create.CreateRatingRequest;
import com.example.reactiveratingservice.response.create.CreatedRating;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    public static final AvgRating DEFAULT_AVG_RATING = new AvgRating(BigDecimal.valueOf(0.00));

    private final ProductService productService;
    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;

    @Override
    public Mono<CreatedRating> create(CreateRatingRequest request) {
        String productCode = request.getRating().productCode();

        return productService.existsByCode(productCode)
                .filter(Boolean::booleanValue)
                .switchIfEmpty(Mono.error(new ProductNotFoundException(productCode)))
                .flatMap(ignored -> ratingRepository.save(ratingMapper.toEntity(request.getRating())))
                .map(ratingMapper::toCreatedRating);
    }

    @Override
    public Mono<AvgRating> getAvgRatingByProductCode(String productCode) {
        return ratingRepository.getAvgRatingValueByProductCode(productCode)
                .map(ratingMapper::toAvgRating)
                .defaultIfEmpty(DEFAULT_AVG_RATING);
    }
}
