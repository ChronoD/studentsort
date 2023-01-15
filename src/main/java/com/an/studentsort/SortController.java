package com.an.studentsort;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/api-v1/sort")
public class SortController {

    @PostMapping
    public SortResult getSorted(@RequestParam("file") MultipartFile file, @RequestParam("method") String method) throws IOException {

        // parse file

        // sort students

        SortResult dummy = SortResult.builder()
                .timeElapsed(Math.random())
                .sortingMethod("Random")
                .students(Arrays.asList(
                        Student.builder().name("First").grade(Math.random()).build(),
                        Student.builder().name("Second").grade(Math.random()).build(),
                        Student.builder().name("Third").grade(Math.random()).build()))
                .build();
        return dummy;
    }
}
