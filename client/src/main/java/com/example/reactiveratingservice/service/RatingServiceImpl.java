package com.example.reactiveratingservice.service;

import com.example.reactiveratingservice.common.Rating;
import com.example.reactiveratingservice.config.WebClientProperties;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class RatingServiceImpl implements RatingService {

    public static final String GET_RATINGS_BY_CODE_URI = "/ratings/{productCode}";
    public static final Rating FALLBACK_VALUE = new Rating(0.0);

    private final WebClientProperties webClientProperties;
    private final WebClient webClient;

    public RatingServiceImpl(WebClientProperties webClientProperties, WebClient.Builder builder) {

        this.webClientProperties = webClientProperties;
        this.webClient = builder
                .baseUrl(webClientProperties.getBaseUrl())
                .build();

    }

    @Override
    public Mono<Rating> getRatingByProductCode(String productCode) {

        return webClient
                .get()
                .uri(GET_RATINGS_BY_CODE_URI, productCode)
                .retrieve()
                .bodyToMono(Rating.class)
                .timeout(Duration.ofMillis(webClientProperties.getTimeout()))
                .retry(webClientProperties.getNumRetries())
                .onErrorReturn(FALLBACK_VALUE);

    }

}
