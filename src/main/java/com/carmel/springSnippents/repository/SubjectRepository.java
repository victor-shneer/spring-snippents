package com.carmel.springSnippents.repository;

import com.carmel.springSnippents.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
