package com.tech552.springbootactuatordemo.repos.student;

import com.tech552.springbootactuatordemo.models.student.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends CrudRepository<Student, Long> {
}
