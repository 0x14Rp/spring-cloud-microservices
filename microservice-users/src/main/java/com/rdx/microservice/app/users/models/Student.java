package com.rdx.microservice.app.users.models;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private String  email;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Instant createAt;

    public Long getId() {
        return id;
    }

    public Student setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Student setEmail(String email) {
        this.email = email;
        return this;
    }

    public Instant getCreateAt() {
        return createAt;
    }

    public Student setCreateAt(Instant createAt) {
        this.createAt = createAt;
        return this;
    }
}
