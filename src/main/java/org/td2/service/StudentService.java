package org.td2.service;

import org.springframework.stereotype.Service;
import org.td2.entity.Student;

import java.util.List;

@Service
public class StudentService {

    public List<Student> createStudents(List<Student> students){
        return repository.createStudents(students);
    }
}
