package com.omaryusufonalan.carla_exercise_a.mapper;

import com.omaryusufonalan.carla_exercise_a.dto.response.CompensationResponse;
import com.omaryusufonalan.carla_exercise_a.entity.Compensation;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface CompensationMapper {
    @Named("entityToResponse")
    CompensationResponse entityToResponse(Compensation compensation);

    @Named("entityToListResponse")
    List<CompensationResponse> entityToListResponse(List<Compensation> compensations);
}
