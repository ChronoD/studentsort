package com.an.studentsort;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/api-v1/sort")
public class SortController {

    @GetMapping
    public String getSorted1(){
        return "hello";
    }
}
