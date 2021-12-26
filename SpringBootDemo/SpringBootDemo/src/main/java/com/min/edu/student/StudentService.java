package com.min.edu.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	
	public List<StudentDto> getAllStudent(){
		return studentRepository.findAll();
	}
	
//	public List<StudentDto> getAllStudent() {
//		return List.of(
//				new StudentDto(1L, 20, "banan@gmail.com", "banan", LocalDate.of(2000, Month.JANUARY, 5)),
//				new StudentDto(2L, 18, "kakao@gmail.com", "kakao", LocalDate.of(2000, Month.JANUARY, 5))
//				);
//	}
	
	public void addNewStudent(StudentDto student) {
		Optional<StudentDto> studentOptional = 
				studentRepository.findStudentByEmail(student.getEmail());
		
		if(studentOptional.isPresent()) {
			throw new IllegalMonitorStateException("사용중인 이메일");
		}
		studentRepository.save(student);
		
	}
}
