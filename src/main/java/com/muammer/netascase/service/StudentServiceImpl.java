package com.muammer.netascase.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muammer.netascase.model.Student;
import com.muammer.netascase.repository.StudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;

	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	private List<Student> savedStudents;
	public static byte[] image;
	public static String city;

	public StudentServiceImpl() {
		savedStudents = new ArrayList<>();
	}

	@Override
	public List<Student> getAllStudent() {

		List<Student> list = new ArrayList<Student>();

		for (Student item : studentRepository.findAll()) {
			list.add(item);
		}

		logger.info("Returning all the students with size {}", list.size());

		return list;
	}

	@Override
	public void saveStudent(Student student) {

		student.setStudentNumber(getRandomId());
		java.sql.Blob blob = null;
		try {
			blob = new javax.sql.rowset.serial.SerialBlob(image);
		} catch (Exception e) {

		}
		student.setImage(blob);
		student.setCity(city);
		blob = null;
		city = null;
		System.out.println(student.toString());
		savedStudents.add(student);
		studentRepository.save(student);
		logger.info("Student is saved: {}", student);
	}

	private String getRandomId() {
		return UUID.randomUUID().toString().substring(0, 8);
	}

	@Override
	public boolean updateStudent(Student student) {

		System.out.println(student.toString());
		studentRepository.save(student);

		return true;

	}

	@Override
	public boolean deleteStudent(Student student) {

		studentRepository.delete(student);
		return true;

	}

}
