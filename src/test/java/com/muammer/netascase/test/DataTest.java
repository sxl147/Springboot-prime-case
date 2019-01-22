package com.muammer.netascase.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
public class DataTest {

	private StudentRepository studentRepository;

	@Autowired
	public void setProductRepository(StudentRepository StudentRepository) {
		this.studentRepository = StudentRepository;
	}

	@SuppressWarnings("unused")
	@Test
	public void testStudentNumberCannotbeNull() {

		Student s1 = studentRepository.findOne("h2muammerid");
		assertEquals(s1.getStudentName(), "Muammer");
		assertEquals(s1.getStudentSurname(), "Sahin");
		assertEquals(s1.getPhoneNumber(), "(123) 123-1233");
		assertEquals(s1.getCity(), "Ankara");
		assertNotNull(s1);

		Student s2 = studentRepository.findOne("h2aliid");
		assertEquals(s2.getStudentName(), "Ali");
		assertEquals(s2.getStudentSurname(), "Yilmaz");
		assertEquals(s2.getPhoneNumber(), "(456) 456-4566");
		assertEquals(s2.getCity(), "Kirsehir");
		assertNotNull(s2);

		Student s3 = studentRepository.findOne("h2ahmetid");
		assertEquals(s3.getStudentName(), "Ahmet");
		assertEquals(s3.getStudentSurname(), "Yildirim");
		assertEquals(s3.getPhoneNumber(), "(190) 719-0719");
		assertEquals(s3.getCity(), "Istanbul");
		assertNotNull(s3);

	}

}
