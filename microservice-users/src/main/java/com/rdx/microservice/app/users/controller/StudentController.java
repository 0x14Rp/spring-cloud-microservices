package com.rdx.microservice.app.users.controller;

import com.rdx.microservice.app.users.models.Student;
import com.rdx.microservice.app.users.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<?> allStudents() {
        return ResponseEntity.ok().body(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable Long id) {
        Optional<Student> o = studentService.findById(id);
        if (o.isEmpty()) {

            return ResponseEntity.notFound().build();
        }
            return ResponseEntity.ok(o.get());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Student student) {

        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editStudent(@RequestBody Student student, @PathVariable Long id) {
        Optional<Student> o = studentService.findById(id);
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Student editStudent = o.get();
        editStudent.setName(student.getName());
        editStudent.setLastName(student.getLastName());
        editStudent.setEmail(student.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(editStudent));

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeStudent(@PathVariable Long id) {
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
