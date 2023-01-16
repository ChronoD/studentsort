package com.an.studentsort;

import com.an.studentsort.dtos.StudentDto;
import com.an.studentsort.utils.StudentSorter;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class StudentSorterTest {
    private StudentSorter sorter = new StudentSorter();
    private final List<StudentDto> DUMMY_STUDENTS_1 = getDummyStudents("First", "Second", "Third");
    private final List<StudentDto> DUMMY_STUDENTS_2 = Stream.concat(DUMMY_STUDENTS_1.stream(), getDummyStudents("Fourth", "Fifth", "Sixth").stream())
            .collect(Collectors.toList());


    @Test
    void bubbleSortsStudents1() throws IOException {
        List<StudentDto> sortedStudents = sorter.bubbleSort(DUMMY_STUDENTS_1);
        // TODO
    }

    @Test
    void bubbleSortsStudents2() throws IOException {
        List<StudentDto> sortedStudents = sorter.bubbleSort(DUMMY_STUDENTS_2);
        // TODO
    }

    @Test
    void heapSortsStudents1() throws IOException {
        // TODO
    }

    @Test
    void heapSortsStudents2() throws IOException {
        // TODO
    }


    @Test
    void mergeSortsStudents1() throws IOException {
        // TODO
    }

    @Test
    void mergeSortsStudents2() throws IOException {
        // TODO
    }


    public List<StudentDto> getDummyStudents(String name1, String name2, String name3) {
        return Arrays.asList(
                StudentDto.builder().name(name1).grade(Math.random()).build(),
                StudentDto.builder().name(name2).grade(Math.random()).build(),
                StudentDto.builder().name(name3).grade(Math.random()).build());
    }
}
