package com.an.studentsort.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class SortResultDto implements Serializable {
    private List<StudentDto> students;
    private String sortingMethod;
    private long timeElapsedInMs;
}
