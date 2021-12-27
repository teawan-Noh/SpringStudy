package com.min.edu.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

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
	
	public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if(!exists) {
			throw new IllegalArgumentException("학생이 존재하지 않습니다");
		}
		studentRepository.deleteById(studentId);
	}
	
	@Transactional
	public void updateStudent(Long studentId, String name, String email) {
		StudentDto student = studentRepository.findById(studentId).orElseThrow(()->new IllegalStateException("해당"+studentId+"학생은 없습니다"));
		
		if(name != null && name.length()>0 && !Objects.equals(student.getName(), name)) {
			student.setName(name);
		}
		if(email != null && email.length()>0 && !Objects.equals(student.getEmail(), email)) {
			Optional<StudentDto> studentOptional = studentRepository.findStudentByEmail(email);
			System.out.println(studentOptional.isPresent());
			if(studentOptional.isPresent()) {
				throw new IllegalStateException("존재하는 email 입니다");
			}
			student.setEmail(email);
		}
		
	}
}
