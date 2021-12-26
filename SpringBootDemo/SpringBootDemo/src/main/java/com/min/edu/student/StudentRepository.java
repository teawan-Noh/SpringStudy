package com.min.edu.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/*
 * DAO의 기능을 Repository의 역할을 하게 되는 OCP
 * JpaRepository는 구현된 객체를 사용하여/ Override해서 사용함
 * 
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentDto, Long>{

	// 반드시 mapping되어있는 JPA @Entity의 클레스명과 같아야한다.
	@Query("SELECT s FROM StudentDto s WHERE s.email=?1")
	Optional<StudentDto> findStudentByEmail(String email);
}
