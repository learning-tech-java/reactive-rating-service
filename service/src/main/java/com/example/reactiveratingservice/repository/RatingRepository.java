package com.example.reactiveratingservice.repository;

import com.example.reactiveratingservice.entity.RatingEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.UUID;

public interface RatingRepository extends ReactiveCrudRepository<RatingEntity, UUID> {

    /**
     * Получение среднего рейтинга товара по коду
     *
     * @param productCode - код товара
     * @return - средний рейтинг товара
     */
    @Query("""
            SELECT AVG(value)
            FROM rating
            WHERE product_code = :productCode
            """)
    Mono<BigDecimal> getAvgRatingValueByProductCode(@Param("productCode") String productCode);
}
