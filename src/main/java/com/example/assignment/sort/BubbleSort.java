package com.example.assignment.sort;

import com.example.assignment.model.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BubbleSort implements Sort {

    @Override
    public List<Student> sortStudentsByPerformance(List<Student> unsortedStudents) {
        Student[] students = unsortedStudents.toArray(Student[]::new);
        int studentsAmount = students.length - 1;
        for (int i = 0; i < studentsAmount; i++) {
            for (int j = 1; j < studentsAmount - i; j++) {
                if (students[j - 1].grade() > students[j].grade()) {
                    Student temp = students[j];
                    students[j] = students[j - 1];
                    students[j - 1] = temp;
                }
            }
        }
        return Arrays.stream(students).toList();
    }
}
