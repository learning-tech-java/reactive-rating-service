package com.example.reactiveratingservice.repository;

import com.example.reactiveratingservice.entity.RatingEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface RatingRepository extends ReactiveCrudRepository<RatingEntity, UUID> {

    /**
     * Поиск рейтинга продукта по коду
     *
     * @param code - код продукта
     * @return - рейтинг продукта
     */
    Mono<RatingEntity> findByCode(String code);

}
