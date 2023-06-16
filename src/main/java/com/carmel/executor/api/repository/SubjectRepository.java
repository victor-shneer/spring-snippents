package com.carmel.executor.api.repository;

import com.carmel.executor.api.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;


public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
