package com.example.reactiveratingservice.service;

import com.example.reactiveratingservice.common.AvgRating;
import reactor.core.publisher.Mono;

public interface RatingService {

    /**
     * Получение среднего рейтинга товара по коду
     *
     * @param productCode - код товара
     * @return - средний рейтинг товара
     */
    Mono<AvgRating> getAvgRatingByProductCode(String productCode);
}
