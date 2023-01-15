package com.an.studentsort;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/api-v1/sort")
public class SortController {

    @GetMapping
    public String getSorted1(){
        return "hello";
    }

    @PostMapping("/a")
    public String getSorted2(@RequestParam("file") MultipartFile file){
        return "hello";
    }
}
