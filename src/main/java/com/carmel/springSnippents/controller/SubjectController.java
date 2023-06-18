package com.carmel.springSnippents.controller;

import com.carmel.springSnippents.entity.Student;
import com.carmel.springSnippents.entity.Subject;
import com.carmel.springSnippents.repository.StudentRepository;
import com.carmel.springSnippents.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/subjects")
public class SubjectController {
        @Autowired
        SubjectRepository subjectRepository;

        @Autowired
        StudentRepository studentRepository;

        @GetMapping
        List<Subject> getSubject(){return subjectRepository.findAll();}

        @PostMapping
        Subject createSubject(@RequestBody Subject subject){ return subjectRepository.save(subject);}

        @PutMapping("/{subjectId}/students/{studentId")
        Subject enrolledStudentToSubject(
                @PathVariable Integer subjectId,
                @PathVariable Integer studentId
        ){
                Subject subject = subjectRepository.findById(subjectId).get();
                Student student = studentRepository.findById(subjectId).get();
                subject.enrollStudent(student);
                subjectRepository.save(subject);
                return subject;
        }
}

