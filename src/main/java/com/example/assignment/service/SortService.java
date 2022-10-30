package com.example.assignment.service;

import com.example.assignment.model.SortType;
import com.example.assignment.model.Student;

import java.io.FileNotFoundException;
import java.util.List;

public interface SortService {
    List<Student> sortStudentsByGrade(SortType type) throws FileNotFoundException;
}
