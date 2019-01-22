package com.muammer.netascase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muammer.netascase.model.Student;

@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, String> {

}
