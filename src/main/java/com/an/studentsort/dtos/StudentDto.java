package com.an.studentsort.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class StudentDto implements Serializable {
    private String name;
    private double grade;
}
