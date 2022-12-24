package com.tech552.springbootactuatordemo.repos.person;

import com.tech552.springbootactuatordemo.models.person.Person;
import com.tech552.springbootactuatordemo.models.student.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository  extends CrudRepository<Person, Long> {
}
