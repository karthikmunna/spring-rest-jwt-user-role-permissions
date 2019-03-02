package com.fullstackblog.sms.service;

import com.fullstackblog.sms.models.Student;
import com.fullstackblog.sms.repository.StudentRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class StudentServiceTest {

    StudentServiceImpl studentService;

    @Mock
    StudentRepository studentRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        studentService = new StudentServiceImpl(studentRepository);
    }

    @Test
    public void findAllStudents() {
        Student student = new Student();
        List<Student> studentsList = new ArrayList<>();
        studentsList.add(student);

        when(studentService.findAllStudents()).thenReturn(studentsList);

        List<Student> students = studentService.findAllStudents();
        assertEquals(students.size(),1);
        verify(studentRepository, times(1)).findAll();
    }
}