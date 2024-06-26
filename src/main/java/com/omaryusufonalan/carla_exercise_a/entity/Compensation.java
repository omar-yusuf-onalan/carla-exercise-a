package com.omaryusufonalan.carla_exercise_a.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "compensation")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Compensation {
    @Id
    @GeneratedValue
    private Long id;

    private String timestamp;

    private String ageRange;

    private String industry;

    private String jobTitle;

    private String annualSalary;

    private String currency;

    private String location;

    private String postCollegeExperience;

    private String additionalContext;

    private String otherCurrency;
}
