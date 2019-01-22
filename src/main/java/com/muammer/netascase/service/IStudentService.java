package com.muammer.netascase.service;

import java.util.List;

import com.muammer.netascase.model.Student;

public interface IStudentService {
	
	List<Student> getAllStudent();
	void saveStudent(final Student student);	
	boolean updateStudent(Student student);
	boolean deleteStudent(Student student);
	
}
