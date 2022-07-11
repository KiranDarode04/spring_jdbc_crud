package com.springjdbcVaibhav;


public class Student {
	private int id;
	private String fname;
	
	public Student(int id, String fname) {
		super();
		this.id = id;
		this.fname = fname;
	}
		
	public Student() {
		super();
	}
	
		
	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
}
