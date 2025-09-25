package edu.ccrm.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private String regNo;
    private String email;
    private Status status;
    private LocalDateTime regDate;
    private List<Course> enrolledCourses = new ArrayList<>();

    public Student(String id, String regNo, String fullName, String email, Status status, LocalDateTime regDate) {
        super(id, fullName);
        this.regNo = regNo;
        this.email = email;
        this.status = status;
        this.regDate = regDate;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public List<Course> getEnrolledCourses() {
        return new ArrayList<>(enrolledCourses); // Defensive copying
    }

    public void addCourse(Course course) {
        enrolledCourses.add(course);
    }

    @Override
    public String toString() {
        return "Student{id=" + getId() + ", regNo=" + regNo + ", name=" + getFullName() + "}";
    }

    public double getGPA() {
        // Simplified GPA calculation
        return enrolledCourses.stream().mapToDouble(Course::getCredits).average().orElse(0.0);
    }
}