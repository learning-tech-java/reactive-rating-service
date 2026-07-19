package com.example.reactiveratingservice.mapper;

import com.example.reactiveratingservice.common.AvgRating;
import com.example.reactiveratingservice.config.MapStructConfig;
import com.example.reactiveratingservice.entity.RatingEntity;
import com.example.reactiveratingservice.request.create.CreateRating;
import com.example.reactiveratingservice.response.create.CreatedRating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;

@Mapper(
        config = MapStructConfig.class
)
public interface RatingMapper {

    CreatedRating toCreatedRating(RatingEntity ratingEntity);

    @Mapping(target = "id", ignore = true)
    RatingEntity toEntity(CreateRating rating);

    @Mapping(target = "value", source = "ratingValue")
    AvgRating toAvgRating(BigDecimal ratingValue);
}
