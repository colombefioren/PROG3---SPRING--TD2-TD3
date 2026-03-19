package org.td2.service;

import org.springframework.stereotype.Service;
import org.td2.entity.Student;
import org.td2.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> createStudents(List<Student> students) {
        return repository.createStudents(students);
    }

    public String getStudentNames() {
        return repository.getStudents()
                .stream()
                .map(s -> s.getFirstName() + " " + s.getLastName())
                .collect(Collectors.joining("\n"));
    }

    public List<Student> getStudents() {
        return repository.getStudents();
    }
}
