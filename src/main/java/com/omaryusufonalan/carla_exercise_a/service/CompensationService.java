package com.omaryusufonalan.carla_exercise_a.service;

import com.omaryusufonalan.carla_exercise_a.dto.response.CompensationResponse;
import com.omaryusufonalan.carla_exercise_a.mapper.CompensationMapper;
import com.omaryusufonalan.carla_exercise_a.repository.CompensationRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CompensationService {
    private final CompensationRepository compensationRepository;
    private final CompensationMapper compensationMapper;

    public List<CompensationResponse> getAll(Map<String, String> params) {
        StringBuilder beforeWhere = new StringBuilder("SELECT * FROM compensation ");
        StringBuilder afterWhere = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (key.equals("sort")) {
                continue;
            }

            afterWhere.append(key).append(" = ").append(value).append(" AND ");

        }
        afterWhere.delete(afterWhere.length() - 4, afterWhere.length());

        afterWhere.append("ORDER BY ").append(params.get("sort"));

        beforeWhere.append(afterWhere);

        String query = beforeWhere.toString();

        return compensationMapper.entityToListResponse(compensationRepository.getAll(query));
    }
}
