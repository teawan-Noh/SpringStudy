package com.min.edu;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.min.edu.student.StudentDto;

@SpringBootApplication
//@RestController
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

//	@GetMapping
//	public List<StudentDto> hello() {
//		return List.of(
//				new StudentDto(1L, 20, "banan@gmail.com", "banan", LocalDate.of(2000,Month.JANUARY,5)),
//				new StudentDto(2L, 18, "kakao@gmail.com", "kakao", LocalDate.of(2000,Month.JANUARY,5))
//				);
//	}
}
