package com.example.reactiveratingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Сущность рейтинга
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table("rating")
public class RatingEntity {

    /**
     * Идентификатор рейтинга
     */
    @Id
    @Column("id")
    private UUID id;

    /**
     * Код товара
     */
    @Column("product_code")
    private String productCode;

    /**
     * Значение рейтинга
     */
    @Column("value")
    private BigDecimal value;
}
