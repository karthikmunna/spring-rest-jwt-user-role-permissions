package com.fullstackblog.sms.controller;

import com.fullstackblog.sms.models.Student;
import com.fullstackblog.sms.service.MapValidationErrorService;
import com.fullstackblog.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    @PreAuthorize("hasAuthority('CREATE_STUDENT')")
    public ResponseEntity<?> createStudent(@Valid @RequestBody Student student, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidations(result);
        if (errorMap!=null) return errorMap;

        Student newStudent = studentService.saveOrUpdateStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @GetMapping("")
    @PreAuthorize("hasAuthority('VIEW_STUDENT')")
    ResponseEntity<?> getAllStudents(){
        List<Student> students = studentService.findAllStudents();
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @GetMapping("/{nic}")
    @PreAuthorize("hasAuthority('VIEW_STUDENT')")
    public ResponseEntity<?> getStudentByNic(@PathVariable String nic){
        Student student = studentService.findStudentByNic(nic);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasAuthority('EDIT_STUDENT')")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @Valid @RequestBody Student student, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidations(result);
        if (errorMap!=null) return errorMap;

        Student updatedStudent = studentService.saveOrUpdateStudent(student);
        return new ResponseEntity<>(updatedStudent,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_STUDENT')")
    public ResponseEntity<?> deleteStudentById(@PathVariable Long id){
        Student student = studentService.findStudentById(id);
        studentService.deleteStudentById(id);
        return ResponseEntity.ok("Student with id "+id.toString()+" deleted successfully !");
    }

}
