package com.an.studentsort.controller;


import com.an.studentsort.utils.FileParser;
import com.an.studentsort.utils.StudentSorter;
import com.an.studentsort.dtos.SortResultDto;
import com.an.studentsort.dtos.StudentDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/api-v1/sort")
public class SortController {

    @PostMapping
    public SortResultDto getSorted(@RequestParam("file") MultipartFile file, @RequestParam("method") String method) throws IOException {
        List<StudentDto> students = new FileParser().parse(file);
        SortResultDto result = new StudentSorter().sortByMethod(students, method);
        return result;
    }
}
