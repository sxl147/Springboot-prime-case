package com.muammer.netascase.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.muammer.netascase.SpringPrimeApplication;
import com.muammer.netascase.model.Student;
import com.muammer.netascase.repository.StudentRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringPrimeApplication.class)
public class StudentRepositoryTest {

	private StudentRepository studentRepository;

	@Autowired
	public void setProductRepository(StudentRepository StudentRepository) {
		this.studentRepository = StudentRepository;
	}

	@Test
	public void testSaveStudent() {
		// setup product
		Student student = new Student();
		student.setStudentName("Test");
		student.setStudentSurname("Test");
		student.setStudentNumber("Test");
		student.setCity("Test");
		student.setDistinct("Test");
		student.setPhoneNumber("Test");
		student.setImage(null);


		studentRepository.save(student);
		assertNotNull(student.getStudentNumber());	

		Student fetchedStudent = studentRepository.findOne(student.getStudentNumber());

		assertNotNull(fetchedStudent);

		assertEquals(student.getStudentNumber(), fetchedStudent.getStudentNumber());
		assertEquals(student.getStudentName(), fetchedStudent.getStudentName());

		fetchedStudent.setStudentName("Test2");
		studentRepository.save(fetchedStudent);

		Student fetchedUpdatedStudent = studentRepository.findOne(fetchedStudent.getStudentNumber());
		assertEquals(fetchedStudent.getStudentName(), fetchedUpdatedStudent.getStudentName());

		long studentCount = studentRepository.count();
		assertEquals(studentCount, 4);

		Iterable<Student> students = studentRepository.findAll();

		int count = 0;

		for (@SuppressWarnings("unused") Student s : students) {
			count++;
		}

		assertEquals(count, 4);
	}
}
