package com.example.reactiveratingservice.service;

import com.example.reactiveratingservice.common.AvgRating;
import com.example.reactiveratingservice.request.create.CreateRatingRequest;
import com.example.reactiveratingservice.response.create.CreatedRating;
import reactor.core.publisher.Mono;

public interface RatingService {

    /**
     * Создание рейтинга
     *
     * @param request - запрос на создание рейтинга
     * @return - созданный рейтинг
     */
    Mono<CreatedRating> create(CreateRatingRequest request);

    /**
     * Получение рейтинга товара по коду
     *
     * @param code - код товара
     * @return - рейтинг товара
     */
    Mono<AvgRating> getAvgRatingByProductCode(String code);
}
