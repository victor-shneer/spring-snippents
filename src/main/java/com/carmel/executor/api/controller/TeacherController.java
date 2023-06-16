package com.carmel.executor.api.controller;

import com.carmel.executor.api.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.carmel.executor.api.repository.TeacherRepository;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping
    List<Teacher> getTeachers(){ return teacherRepository.findAll();}

    @PostMapping
    Teacher createTeacher(@RequestBody Teacher teacher){
        return teacherRepository.save(teacher);
    }
}
