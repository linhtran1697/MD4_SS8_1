package com.example.studentsearch.model.entity;

public class Student {
    private Long id;
    private String fullName;
    private String major;

    public Student() { }

    public Student(Long id, String fullName, String major) {
        this.id = id;
        this.fullName = fullName;
        this.major = major;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
}
