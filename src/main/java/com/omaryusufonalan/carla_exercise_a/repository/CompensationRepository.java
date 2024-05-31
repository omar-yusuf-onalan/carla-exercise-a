package com.omaryusufonalan.carla_exercise_a.repository;

import com.omaryusufonalan.carla_exercise_a.entity.Compensation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompensationRepository extends JpaRepository<Compensation, Long> {

}
