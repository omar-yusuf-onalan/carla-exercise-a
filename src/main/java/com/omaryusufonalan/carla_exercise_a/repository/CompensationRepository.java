package com.omaryusufonalan.carla_exercise_a.repository;

import com.omaryusufonalan.carla_exercise_a.entity.Compensation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompensationRepository extends JpaRepository<Compensation, Long> {

}
