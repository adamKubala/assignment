package com.example.assignment.service;

import com.example.assignment.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class FileServiceImplementation implements FileService {

    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public List<Student> readStudentsFromFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner in = new Scanner(file);
        String data = "";
        while (in.hasNextLine()) {
            data = in.nextLine();
        }
        JSONArray studentsJson = new JSONArray(data);
        return IntStream.range(0, studentsJson.length())
                .mapToObj(index ->
                        new Student(((JSONObject) studentsJson.get(index)).optString("name"),
                                Double.parseDouble(((JSONObject) studentsJson.get(index)).optString("grade"))))
                .toList();
    }

    @Override
    public List<Student> saveStudentsToFile(List<Student> students) throws IOException {

        String studentsJson = objectMapper.writeValueAsString(students);
        BufferedWriter writer = new BufferedWriter(new FileWriter(("src/main/resources/note.txt")));
        writer.write(studentsJson);
        writer.close();

        return students;
    }
}

