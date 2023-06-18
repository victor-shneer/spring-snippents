package com.carmel.springSnippents.controller;

import com.carmel.springSnippents.entity.Teacher;
import com.carmel.springSnippents.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
