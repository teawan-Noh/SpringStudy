package com.min.edu.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/app")
public class StudentController {

	private StudentService studentService;
	
	@Autowired
	private void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping
	public List<StudentDto> hello(){
		return studentService.getAllStudent();
	}
	
	@PostMapping
	public void addNewStudent(@RequestBody StudentDto studentDto) {
		studentService.addNewStudent(studentDto);
		
	}
}
