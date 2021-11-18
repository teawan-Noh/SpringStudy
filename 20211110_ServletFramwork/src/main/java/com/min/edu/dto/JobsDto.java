package com.min.edu.dto;

import java.io.Serializable;

//DB의 JOBS 데이블의정보,ROW를 담을 수 있는 Data Transfer Object
public class JobsDto implements Serializable {

	private static final long serialVersionUID = 8970007019827411269L;
	
	private String job_id;
	private String job_title;
	private int min_salary;
	private int max_salary;

	public JobsDto() {
	}

	public JobsDto(String job_id, String job_title, int min_salary, int max_salary) {
		super();
		this.job_id = job_id;
		this.job_title = job_title;
		this.min_salary = min_salary;
		this.max_salary = max_salary;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public int getMin_salary() {
		return min_salary;
	}

	public void setMin_salary(int min_salary) {
		this.min_salary = min_salary;
	}

	public int getMax_salary() {
		return max_salary;
	}

	public void setMax_salary(int max_salary) {
		this.max_salary = max_salary;
	}

	@Override
	public String toString() {
		return "Jobs [job_id=" + job_id + ", job_title=" + job_title + ", min_salary=" + min_salary + ", max_salary="
				+ max_salary + "]";
	}

}
