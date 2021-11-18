package com.min.edu.test02;

public class JobAddress {
	private Address addr;
	private String jobname;
	
	public JobAddress() {
		this.addr = new Address("홍길동", "서울시 금천구", "000-11");
		this.jobname = "개발자";
	}

	public JobAddress(Address addr, String jobname) {
		super();
		this.addr = addr;
		this.jobname = jobname;
	}

	@Override
	public String toString() {
		return "JobAdrress [addr=" + addr + ", jobname=" + jobname + "]";
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	
	
}
