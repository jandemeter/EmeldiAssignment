package com.assignment.Assignment.repository;

import com.assignment.Assignment.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
