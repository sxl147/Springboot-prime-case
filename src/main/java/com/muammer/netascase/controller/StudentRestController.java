package com.muammer.netascase.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.muammer.netascase.model.Student;
import com.muammer.netascase.service.IStudentService;

@RestController
public class StudentRestController {

	@Autowired
	private IStudentService studentService;

	@GetMapping("/")
	public String index() {
		return "Muammer Şahin : " + new Date();
	}

	@RequestMapping(path = "/student", method = RequestMethod.GET)
	public List<Student> getAllStudents() {
		
		List<Student> students = studentService.getAllStudent();
		for(int i = 0; i<students.size(); i++) {
			students.get(i).setImage(null);
		}
		
		return students;
	}

	@RequestMapping(value = "/error-test", method = RequestMethod.GET)
	public Student error() throws Exception {
		throw new Exception();
	}
}
