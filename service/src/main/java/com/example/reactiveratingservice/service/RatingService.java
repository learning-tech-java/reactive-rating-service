package com.example.reactiveratingservice.service;

import com.example.reactiveratingservice.common.Rating;
import reactor.core.publisher.Mono;

public interface RatingService {

    /**
     * Получение рейтинга товара по коду
     *
     * @param code - код товара
     * @return - рейтинг товара
     */
    Mono<Rating> getRatingByCode(String code);

}
