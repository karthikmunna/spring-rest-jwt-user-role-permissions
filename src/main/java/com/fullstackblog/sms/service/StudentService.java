package com.fullstackblog.sms.service;

import com.fullstackblog.sms.exceptions.ResourceNotFoundException;
import com.fullstackblog.sms.models.Student;
import com.fullstackblog.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {

    public Student saveOrUpdateStudent(Student student);

    public List<Student> findAllStudents();

    public Student findStudentByNic(String nic);

    public Student findStudentById(Long id);

    public void deleteStudentById(Long id);
}
