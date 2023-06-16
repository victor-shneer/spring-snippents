package com.carmel.executor.api.controller;

import com.carmel.executor.api.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.carmel.executor.api.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentRepository studentRespository;

    @GetMapping
    List<Student> getStudents(){return studentRespository.findAll();}

    @PostMapping
    Student createStudent(@RequestBody Student student){ return studentRespository.save(student);}
}
