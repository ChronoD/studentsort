package com.an.studentsort;

import com.an.studentsort.dtos.StudentDto;
import com.an.studentsort.utils.FileParser;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertEquals;


public class FileParserTest {

    private FileParser parser = new FileParser();
    private final String DUMMY_FILE_1_PATH = "src/test/resources/students1.txt";
    private final String DUMMY_FILE_2_PATH = "src/test/resources/students2.txt";
    private final String DUMMY_FILE_3_PATH = "src/test/resources/students3.txt";

    @Test
    void parsesFile1() throws IOException {
        MultipartFile file1 = getDummyFile(DUMMY_FILE_1_PATH);
        List<StudentDto> students = parser.parse(file1);
        assertEquals("correct number of students", 3, students.size());
    }

    @Test
    void parsesFile2() throws IOException {
        MultipartFile file2 = getDummyFile(DUMMY_FILE_2_PATH);
        List<StudentDto> students = parser.parse(file2);
        assertEquals("correct number of students", 9, students.size());
    }

    @Test
    void parsesFile3Empty() throws IOException {
        MultipartFile file3 = getDummyFile(DUMMY_FILE_3_PATH);
        assertThrows(RuntimeException.class, () -> {
           parser.parse(file3);
        });
    }

    public MultipartFile getDummyFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream input = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("file",
                file.getName(), "text/plain", IOUtils.toByteArray(input));
        return multipartFile;
    }
}
