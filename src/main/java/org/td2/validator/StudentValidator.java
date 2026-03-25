package org.td2.validator;

import org.springframework.stereotype.Component;
import org.td2.entity.Student;
import org.td2.exception.BadRequestException;

import java.util.List;

@Component
public class StudentValidator {

    public void isValid(Student s) {
        if (s.getReference() == null || s.getReference().isBlank()) {
            throw new BadRequestException("Student reference is required");
        }
        if (s.getFirstName() == null || s.getFirstName().isBlank()) {
            throw new BadRequestException("Student first name is required");
        }
        if (s.getLastName() == null || s.getLastName().isBlank()) {
            throw new BadRequestException("Student last name is required");
        }
        if (s.getAge() <= 0) {
            throw new BadRequestException("Age should be grater than 0");
        }
    }

    public void isValid(List<Student> ls) {
        if (ls == null || ls.isEmpty()) {
            throw new BadRequestException("Student list is required");
        }
        for (Student s : ls) {
            isValid(s);
        }
    }
}
