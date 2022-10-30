package com.example.assignment.sort;

import com.example.assignment.model.Student;

import java.util.List;

public interface Sort {
    List<Student> sortStudentsByPerformance(List<Student> unsortedStudents);
}
