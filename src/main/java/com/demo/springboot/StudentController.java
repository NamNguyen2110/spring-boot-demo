package com.demo.springboot;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepo;


    @PostMapping
    public ResponseEntity<?> create() {
        Student student = new Student();
        student.setName(UUID.randomUUID().toString());
        studentRepo.save(student);
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(studentRepo.findAll());
    }

}
