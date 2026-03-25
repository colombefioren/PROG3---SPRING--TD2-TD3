package org.td2.validator;

import org.springframework.stereotype.Component;
import org.td2.entity.Student;
import org.td2.exception.BadRequestException;

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
}
