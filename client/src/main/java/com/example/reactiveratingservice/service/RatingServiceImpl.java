package com.example.reactiveratingservice.service;

import com.example.reactiveratingservice.common.AvgRating;
import com.example.reactiveratingservice.config.WebClientProperties;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.Duration;

public class RatingServiceImpl implements RatingService {

    public static final String GET_AVG_RATING_BY_PRODUCT_CODE_URI = "/ratings/{productCode}";
    public static final AvgRating FALLBACK_VALUE = new AvgRating(BigDecimal.valueOf(0.00));

    private final WebClientProperties webClientProperties;
    private final WebClient webClient;

    public RatingServiceImpl(WebClientProperties webClientProperties, WebClient.Builder builder) {
        this.webClientProperties = webClientProperties;
        this.webClient = builder
                .baseUrl(webClientProperties.getBaseUrl())
                .build();
    }

    @Override
    public Mono<AvgRating> getAvgRatingByProductCode(String productCode) {
        return webClient
                .get()
                .uri(GET_AVG_RATING_BY_PRODUCT_CODE_URI, productCode)
                .retrieve()
                .bodyToMono(AvgRating.class)
                .timeout(Duration.ofMillis(webClientProperties.getTimeout()))
                .retry(webClientProperties.getNumRetries())
                .onErrorReturn(FALLBACK_VALUE);
    }
}
