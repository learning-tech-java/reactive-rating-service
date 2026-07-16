package com.example.reactiveratingservice.service;

import com.example.reactiveratingservice.common.Rating;
import reactor.core.publisher.Mono;

public interface RatingService {

    /**
     * Получение рейтинга продукта по коду
     *
     * @param code - код продукта
     * @return - рейтинг продукта
     */
    Mono<Rating> getRatingByCode(String code);

}
