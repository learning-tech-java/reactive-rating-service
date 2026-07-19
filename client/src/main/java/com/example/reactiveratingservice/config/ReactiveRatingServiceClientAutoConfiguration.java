package com.example.reactiveratingservice.config;

import com.example.reactiveratingservice.service.RatingService;
import com.example.reactiveratingservice.service.RatingServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@AutoConfiguration
@EnableConfigurationProperties(WebClientProperties.class)
public class ReactiveRatingServiceClientAutoConfiguration {

    @Bean
    public RatingService ratingService(WebClientProperties webClientProperties, WebClient.Builder builder) {
        return new RatingServiceImpl(webClientProperties, builder);
    }
}
