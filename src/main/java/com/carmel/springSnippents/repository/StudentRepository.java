package com.carmel.springSnippents.repository;

import com.carmel.springSnippents.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
