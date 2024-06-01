package com.omaryusufonalan.carla_exercise_a.service;

import com.omaryusufonalan.carla_exercise_a.dto.response.CompensationResponse;
import com.omaryusufonalan.carla_exercise_a.entity.Compensation;
import com.omaryusufonalan.carla_exercise_a.mapper.CompensationMapper;
import com.omaryusufonalan.carla_exercise_a.mapper.CompensationRowMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CompensationService {
    private final JdbcTemplate jdbcTemplate;
    private final CompensationMapper compensationMapper;

    public List<CompensationResponse> getAll(Map<String, String> params) {
        StringBuilder query = new StringBuilder("SELECT * FROM compensation ");

        if (params.size() > 1 || (!params.containsKey("sort") && !params.isEmpty())) { // checks if sort is the only param in the map
            query.append("WHERE ");
        }

        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (key.equals("sort")) {
                continue;
            }

            query.append(key).append(" = '").append(value).append("' AND ");

        }

        if (params.size() > 1 || (!params.containsKey("sort") && !params.isEmpty())) { // checks if sort is the only param in the map and deletes extra AND
            query.delete(query.length() - 4, query.length());
        }

        if (params.containsKey("sort")) {
            query.append("ORDER BY ").append(params.get("sort"));
        }

        return compensationMapper.entityToListResponse(jdbcTemplate.query(query.toString(), new CompensationRowMapper()));

    }

    public Compensation getById(Long id, List<String> fields) {
        StringBuilder query = new StringBuilder("SELECT ");

        for (String field : fields) {
            query.append(field).append(",");
        }
        query.deleteCharAt(query.length() - 1); // deletes last extra comma

        query.append(" FROM compensation WHERE id = ").append(id);

        List<Compensation> compensations = jdbcTemplate.query(query.toString(), new CompensationRowMapper());

        if (compensations.isEmpty())
            throw new EntityNotFoundException("Entity not found");

        return compensations.get(0);
    }

    public CompensationResponse getResponseById(Long id, List<String> fields) {
         return compensationMapper.entityToResponse(getById(id, fields));
    }
}