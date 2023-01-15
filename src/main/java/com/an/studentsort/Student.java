package com.an.studentsort;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Student implements Serializable {
    private String name;
    private double grade;
}
