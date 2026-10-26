package com.example.studentsearch.service;

import com.example.studentsearch.exception.StudentNotFoundException;
import com.example.studentsearch.model.entity.Student;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    // Fake data in memory: no database setup required.
    private final List<Student> students = List.of(
            new Student(1L, "Nguyen Van An", "Information Technology"),
            new Student(2L, "Tran Thi Binh", "Business Administration"),
            new Student(3L, "Le Minh Chau", "Computer Science")
    );

    public Student getStudentById(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElseThrow(StudentNotFoundException::new);
    }
}
