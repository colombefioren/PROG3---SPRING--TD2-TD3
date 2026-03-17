package org.td2.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

     @PostMapping("/students")
    public List<Student> createStudents(@RequestBody List<Student> students){
         return service.createStudent(students);
     }
}
