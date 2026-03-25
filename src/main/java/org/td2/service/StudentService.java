package org.td2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.td2.entity.Student;
import org.td2.repository.StudentRepository;
import org.td2.validator.StudentValidator;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository repository;
    private final StudentValidator validator;

    public List<Student> createStudents(List<Student> students) {
        validator.isValid(students);
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
