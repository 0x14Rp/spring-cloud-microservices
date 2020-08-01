package com.rdx.microservice.app.users.services;

import com.rdx.microservice.app.users.models.Student;

import java.util.Optional;

public interface StudentService {

    public Iterable<Student> findAll();

    public Optional<Student> findById(Long id);

    public Student save(Student student);

    public void deleteById(Long id);
}
