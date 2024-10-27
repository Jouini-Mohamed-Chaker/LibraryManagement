package io.chaker.bibspring.services;

import io.chaker.bibspring.models.Student;

import java.util.List;

public interface StudentService {
    void addStudent();
    void deleteStudent();
    void updateStudent();
    Student getStudent();
    List<Student> getAllStudents();
}
