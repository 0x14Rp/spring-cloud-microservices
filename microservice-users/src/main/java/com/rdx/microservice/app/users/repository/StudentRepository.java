package com.rdx.microservice.app.users.repository;

import com.rdx.microservice.app.users.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {



}
