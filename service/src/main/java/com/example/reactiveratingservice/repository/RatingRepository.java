package com.example.reactiveratingservice.repository;

import com.example.reactiveratingservice.entity.RatingEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface RatingRepository extends ReactiveCrudRepository<RatingEntity, UUID> {

    /**
     * Поиск рейтинга товара по коду
     *
     * @param productCode - код товара
     * @return - рейтинг товара
     */
    Mono<RatingEntity> findByProductCode(String productCode);

}
