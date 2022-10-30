package com.example.assignment.service;

import com.example.assignment.model.SortType;
import com.example.assignment.model.Student;
import com.example.assignment.sort.Sort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SortServiceImplementation implements SortService {
    private final Sort bubbleSort;
    private final Sort heapSort;
    private final Sort mergeSort;
    private final FileServiceImplementation fileServiceImplementation;
    private final String STUDENTS_PATH = "src/main/resources/note.txt";

    public SortServiceImplementation(@Qualifier("bubbleSort") Sort bubbleSort,
                                     @Qualifier("heapSort") Sort heapSort,
                                     @Qualifier("mergeSort") Sort mergeSort,
                                     FileServiceImplementation fileServiceImplementation) {
        this.bubbleSort = bubbleSort;
        this.heapSort = heapSort;
        this.mergeSort = mergeSort;
        this.fileServiceImplementation = fileServiceImplementation;
    }

    @Override
    public List<Student> sortStudentsByGrade(SortType type) throws FileNotFoundException {
        List<Student> students = fileServiceImplementation.readStudentsFromFile(STUDENTS_PATH);
        List<Student> sortedStudents = new ArrayList<>();
        switch (type) {
            case HEAP:
                sortedStudents = heapSort.sortStudentsByPerformance(students);
                break;
            case BUBBLE:
                sortedStudents = bubbleSort.sortStudentsByPerformance(students);
                break;
            case MERGE:
                sortedStudents = mergeSort.sortStudentsByPerformance(students);
                break;
        }
        return sortedStudents;
    }
}
