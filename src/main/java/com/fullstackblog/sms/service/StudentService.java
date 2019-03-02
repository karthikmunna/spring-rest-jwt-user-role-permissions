package com.fullstackblog.sms.service;

import com.fullstackblog.sms.models.Student;
import java.util.List;

public interface StudentService {

    public Student saveOrUpdateStudent(Student student);

    public List<Student> findAllStudents();

    public Student findStudentByNic(String nic);

    public Student findStudentById(Long id);

    public void deleteStudentById(Long id);
}
