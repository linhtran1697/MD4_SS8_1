package com.example.studentsearch.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException() {
        super("Sinh viên không tồn tại");
    }
}
