package org.td2.controller;

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
    public List<Student> createStudents(@RequestBody List<Student> students) {
        return service.createStudents(students);
    }

    @GetMapping("/students")
    public String getStudentNames(@RequestHeader("Accept") String accept) {
        if ("text/plain".equalsIgnoreCase(accept)) {
            return service.getStudentNames();
        } else {
            return "Format non supporté";
        }

    }
}
