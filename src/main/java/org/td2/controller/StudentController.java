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
        if (accept.toLowerCase().contains("text/plain")
                || accept.contains("*/*")) {
            return service.getStudentNames();
        } else {
            return "Format non supporté";
        }
    }

//    @GetMapping("/students")
//    public String getStudentNames(HttpServletRequest request) {
//        String accept = request.getHeader("Accept");
//        if ( accept.toLowerCase().contains("text/plain")
//    || accept.contains("*/*")) {
//            return service.getStudentNames();
//        } else {
//            return "Format non supporté";
//        }
//    }

}
