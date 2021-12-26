package com.min.edu.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
//		return args->{
//			StudentDto banana = new StudentDto(20, "banan@gmail.com", "banan", LocalDate.of(2000,Month.JANUARY,5));
//			StudentDto kakao =  new StudentDto(18, "kakao@gmail.com", "kakao", LocalDate.of(2000,Month.JANUARY,5));
//			repository.saveAll(List.of(banana,kakao));
//		};
		
		//StudentDto에 @Transient에 의해서 age는 값을 입력받지 않는다
		//getAge의 연산을 dob를 통해서 기간객체(period)를 통해서 연산하여 반환하기 때문에 age는 입력할 필요가 없다
		return args->{
			StudentDto banana = new StudentDto(20, "banan@gmail.com", "banan", LocalDate.of(1995,Month.JANUARY,5));
			StudentDto kakao =  new StudentDto(18, "kakao@gmail.com", "kakao", LocalDate.of(1980,Month.JANUARY,5));
			repository.saveAll(List.of(banana,kakao));
		};
	}
}
