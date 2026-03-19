package org.td2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.td2.entity.Student;
import org.td2.service.StudentService;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/students")
    public ResponseEntity<List<Student>> createStudents(@RequestBody List<Student> students) {
        try {

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(service.createStudents(students));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> getStudents(@RequestHeader(value = "Accept", required = false) String accept) {
        try {
            if (accept == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            if (accept.contains("application/json")) {
                return ResponseEntity.status(HttpStatus.OK)
                        .body(service.getStudents());
            }
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
