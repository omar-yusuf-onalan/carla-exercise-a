package com.omaryusufonalan.carla_exercise_a.mapper;

import com.omaryusufonalan.carla_exercise_a.entity.Compensation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompensationRowMapper implements RowMapper<Compensation> {

    @Override
    public Compensation mapRow(ResultSet rs, int rowNum) throws SQLException {
        Compensation compensation = new Compensation();
        if (columnExists(rs, "id")) {
            compensation.setId(rs.getLong("id"));
        }
        if (columnExists(rs, "timestamp")) {
            compensation.setTimestamp(rs.getString("timestamp"));
        }
        if (columnExists(rs, "age_range")) {
            compensation.setAgeRange(rs.getString("age_range"));
        }
        if (columnExists(rs, "industry")) {
            compensation.setIndustry(rs.getString("industry"));
        }
        if (columnExists(rs, "job_title")) {
            compensation.setJobTitle(rs.getString("job_title"));
        }
        if (columnExists(rs, "annual_salary")) {
            compensation.setAnnualSalary(rs.getDouble("annual_salary"));
        }
        if (columnExists(rs, "currency")) {
            compensation.setCurrency(rs.getString("currency"));
        }
        if (columnExists(rs, "location")) {
            compensation.setLocation(rs.getString("location"));
        }
        if (columnExists(rs, "post_college_experience")) {
            compensation.setPostCollegeExperience(rs.getString("post_college_experience"));
        }
        if (columnExists(rs, "additional_context")) {
            compensation.setAdditionalContext(rs.getString("additional_context"));
        }
        if (columnExists(rs, "other_currency")) {
            compensation.setOtherCurrency(rs.getString("other_currency"));
        }
        return compensation;
    }

    private boolean columnExists(ResultSet rs, String columnName) throws SQLException {
        try {
            rs.findColumn(columnName);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}