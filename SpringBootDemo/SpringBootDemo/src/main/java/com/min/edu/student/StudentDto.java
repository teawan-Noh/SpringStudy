package com.min.edu.student;

import java.time.LocalDate;
/*
 * StudentDto를 MySql(student)와 ORM을 생성해
 * JPA Annotation을 사용해서 작성
 */
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity //JAP 선언
@Table  // TableORM
public class StudentDto {

	@Id //PrimaryKey 선언
	@SequenceGenerator( // Sequence 테이블 연결
			name = "student_sequence", //Sequence table의 이름과 컬럼명을 "student_sequence"로 하겠다
			sequenceName = "student_sequence",
			allocationSize = 1
			)
	@GeneratedValue(  //Sequence 테이블 선언
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence"  //Sequence를 사용하되 사용하는 sequence table은 "student_sequence"이다
			)
	private Long id;
	
	//ORM 연결된 컬럼을 제거함
	@Transient
	private Integer age;
	private String email;
	private String name;
	private LocalDate dob;
	
	public StudentDto() {
	}

	//main과 db없이 테스트할때 사용
	public StudentDto(Long id, Integer age, String email, String name, LocalDate dob) {
		super();
		this.id = id;
		this.age = age;
		this.email = email;
		this.name = name;
		this.dob = dob;
	}

	//DB연결 후 jpa를 통해서 자동으로 id등록을 테스트 할 때 사용
	public StudentDto(Integer age, String email, String name, LocalDate dob) {
		super();
		this.age = age;
		this.email = email;
		this.name = name;
		this.dob = dob;
	}

	//DTO에 Transient를 사용하여 제외 후 age를 계산하여 넣을 때 사용
	public StudentDto(Long id, String email, String name, LocalDate dob) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.dob = dob;
	}

	public StudentDto(String email, String name, LocalDate dob) {
		super();
		this.email = email;
		this.name = name;
		this.dob = dob;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	
}
