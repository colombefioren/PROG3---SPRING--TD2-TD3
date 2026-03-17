package org.td2.repository;

import org.springframework.stereotype.Repository;
import org.td2.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {


    List<Student> list = new ArrayList<>();

    public List<Student> createStudents(List<Student> students) {
        list.addAll(students);
        return list;
    }

}
