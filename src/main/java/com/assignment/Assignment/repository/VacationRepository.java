package com.assignment.Assignment.repository;

import com.assignment.Assignment.entity.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacationRepository extends JpaRepository<Vacation, Long> {
    List<Vacation> findByCreatedBy_Id(Long employeeId);
}
