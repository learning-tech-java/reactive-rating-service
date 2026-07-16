package com.example.reactiveratingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @Column("code")
    private String code;

    /**
     * Значение рейтинга
     */
    @Column("value")
    private Double value;

}
