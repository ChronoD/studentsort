package com.an.studentsort.utils;

import com.an.studentsort.dtos.SortResultDto;
import com.an.studentsort.dtos.StudentDto;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StudentSorter {

    public SortResultDto sortByMethod(List<StudentDto> students, String sortMethod) {

        long startTime = System.nanoTime();
        switch (sortMethod) {
            case "bubble":
                bubbleSort(students);
                break;
            case "heap":
                bubbleSort(students);
                break;
            case "merge":
                bubbleSort(students);
                break;
            default:
                throw new RuntimeException("Unexpected sort method");
        }

        long elapsedTime = System.nanoTime() - startTime;
        elapsedTime = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);

        return SortResultDto.builder()
                .timeElapsedInMs(elapsedTime)
                .sortingMethod(sortMethod)
                .students(students)
                .build();
    }

    public List<StudentDto> bubbleSort(List<StudentDto> students) {
        // TODO
//        Object[] studentsArr = (Student[]) students.toArray();
//        bubbleSort(studentsArr);
//        return List.of(studentsArr);
        return students;
    }


    public List<StudentDto> heapSort(List<StudentDto> students) {
        StudentDto[] studentsArr = (StudentDto[]) students.toArray();
        // TODO
        // heapSort(studentsArr);

        return List.of(studentsArr);
    }

    public List<StudentDto> mergeSort(List<StudentDto> students) {
        StudentDto[] studentsArr = (StudentDto[]) students.toArray();
        // TODO
        // mergeSort(studentsArr);

        return List.of(studentsArr);
    }

    private void bubbleSort(StudentDto students[]) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (students[j].getGrade() > students[j + 1].getGrade()) {
                    StudentDto temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
    }

}