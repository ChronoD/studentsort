package com.an.studentsort;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class SortResult implements Serializable {
    private List<Student> students;
    private String sortingMethod;
    private double timeElapsed;
}
