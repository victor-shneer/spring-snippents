package com.carmel.springSnippents.repository;

import com.carmel.springSnippents.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
