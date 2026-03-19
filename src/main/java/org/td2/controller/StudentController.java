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

    @GetMapping("/students")
    public String getStudentNames(@RequestHeader("Accept") String accept) {
        if (accept.toLowerCase().contains("text/plain")
                || accept.contains("*/*")) {
            return service.getStudentNames();
        } else {
            return "Format non supporté";
        }
    }

}
