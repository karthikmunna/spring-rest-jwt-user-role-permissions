package com.fullstackblog.sms.repository;

import com.fullstackblog.sms.models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findAll();

    Optional<Student> findByNic(String nic);
}
