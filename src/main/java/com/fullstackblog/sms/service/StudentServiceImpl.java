package com.fullstackblog.sms.service;

import com.fullstackblog.sms.exceptions.ResourceNotFoundException;
import com.fullstackblog.sms.models.Student;
import com.fullstackblog.sms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveOrUpdateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentByNic(String nic) {
        Student student = studentRepository.findByNic(nic).orElseThrow(
                ()-> new ResourceNotFoundException("Student","nic",nic));
        return student;
    }

    @Override
    public Student findStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Student","id",id)
        );
        return student;
    }

    @Override
    public void deleteStudentById(Long id) {
        Student student = findStudentById(id);
        studentRepository.delete(student);
    }
}
