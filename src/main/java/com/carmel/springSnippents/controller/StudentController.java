package com.carmel.springSnippents.controller;

import com.carmel.springSnippents.entity.Student;
import com.carmel.springSnippents.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
