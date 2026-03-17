package org.td2.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
    public List<Student> createStudents(@RequestBody List<Student> students){
         return service.createStudent(students);
     }
}
