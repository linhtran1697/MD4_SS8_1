package com.example.studentsearch.controller;

import com.example.studentsearch.model.entity.Student;
import com.example.studentsearch.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        // Exception is handled centrally; no try-catch here.
        return studentService.getStudentById(id);
    }
}
