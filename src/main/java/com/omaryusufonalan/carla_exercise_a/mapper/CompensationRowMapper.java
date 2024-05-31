package com.omaryusufonalan.carla_exercise_a.mapper;

import com.omaryusufonalan.carla_exercise_a.entity.Compensation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompensationRowMapper implements RowMapper<Compensation> {

    @Override
    public Compensation mapRow(ResultSet rs, int rowNum) throws SQLException {
        Compensation compensation = new Compensation();
        compensation.setId(rs.getLong("id"));
        compensation.setTimestamp(rs.getString("timestamp"));
        compensation.setAgeRange(rs.getString("age_range"));
        compensation.setIndustry(rs.getString("industry"));
        compensation.setJobTitle(rs.getString("job_title"));
        compensation.setAnnualSalary(rs.getDouble("annual_salary"));
        compensation.setCurrency(rs.getString("currency"));
        compensation.setLocation(rs.getString("location"));
        compensation.setPostCollegeExperience(rs.getString("post_college_experience"));
        compensation.setAdditionalContext(rs.getString("additional_context"));
        compensation.setOtherCurrency(rs.getString("other_currency"));
        return compensation;
    }
}