package com.omaryusufonalan.carla_exercise_a.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompensationResponse{
    private Long id;

    private String timestamp;

    private String ageRange;

    private String industry;

    private String jobTitle;

    private Double annualSalary;

    private String currency;

    private String location;

    private String postCollegeExperience;

    private String additionalContext;

    private String otherCurrency;
}
