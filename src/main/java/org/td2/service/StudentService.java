package org.td2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.td2.entity.Student;
import org.td2.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> createStudents(List<Student> students){
        return repository.createStudents(students);
    }
}
