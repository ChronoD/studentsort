package com.an.studentsort.utils;

import com.an.studentsort.dtos.StudentDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class FileParser {
    public List<StudentDto> parse(MultipartFile file) throws RuntimeException, IOException {
        if (!file.isEmpty()) {
            List<StudentDto> students = new ArrayList<>();

            InputStream inputStream = file.getInputStream();
            new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                    .lines()
                    .forEach(line -> {
                        String[] elements = line.split(",");
                        String name = elements[0];
                        String grade = elements[1];
                        if (name == null || name.isBlank() || grade == null || grade.isBlank()) {
                            return;
                        }
                        StudentDto student = StudentDto.builder()
                                .name(name)
                                .grade(Double.valueOf(grade))
                                .build();
                        students.add(student);
                    });
            return students;
        }
        throw new RuntimeException("Could not parse the file");
    }
}
