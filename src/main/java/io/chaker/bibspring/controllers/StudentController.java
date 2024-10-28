package io.chaker.bibspring.controllers;


import io.chaker.bibspring.models.Student;
import io.chaker.bibspring.repositories.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    public final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/api/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/api/students/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @PostMapping("/api/students/addMany")
    public List<Student> addStudents(@RequestBody List<Student> students) {
        return studentRepository.saveAll(students);
    }
    
    @PostMapping("/api/students/addOne")
    public Student addStudents(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/api/students/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentRepository.findById(id)
                .map(s -> {
                    s.setName(student.getName());
                    s.setEmail(student.getEmail());
                    s.setActiveSubscription(student.getActiveSubscription());
                    return studentRepository.save(s);
                })
                .orElse(null);
    }

    @DeleteMapping("/api/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

    @DeleteMapping("/api/students")
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }
}
