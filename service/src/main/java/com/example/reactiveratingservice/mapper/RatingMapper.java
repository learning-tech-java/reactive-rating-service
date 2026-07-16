package com.example.reactiveratingservice.mapper;

import com.example.reactiveratingservice.common.Rating;
import com.example.reactiveratingservice.config.MapStructConfig;
import com.example.reactiveratingservice.entity.RatingEntity;
import org.mapstruct.Mapper;

@Mapper(
        config = MapStructConfig.class
)
public interface RatingMapper {

    Rating toRating(RatingEntity ratingEntity);

}
