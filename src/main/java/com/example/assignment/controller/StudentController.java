package com.example.assignment.controller;

import com.example.assignment.model.SortType;
import com.example.assignment.model.Student;
import com.example.assignment.service.FileService;
import com.example.assignment.service.SortService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final SortService sortService;
    private final FileService fileService;

    public StudentController(SortService sortService, FileService fileService) {
        this.sortService = sortService;
        this.fileService = fileService;
    }

    @GetMapping("/{sortType}")
    public ResponseEntity<List<Student>> getSortedStudents(@PathVariable SortType sortType) throws FileNotFoundException {
        return ResponseEntity.ok(sortService.sortStudentsByGrade(sortType));
    }

    @PostMapping()
    public ResponseEntity<List<Student>> saveSortedStudents(@RequestBody List<Student> students) throws IOException {
        return ResponseEntity.ok(fileService.saveStudentsToFile(students));
    }
}
