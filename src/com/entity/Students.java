package com.entity;

public class Students {
	private int studid;
    private String studname;
	private int age;
	private String gender;
	private String email;
	private String classname;
	
	
	
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Students(int studid, String studname, int age, String gender, String email, String classname) {
		super();
		this.studid = studid;
		this.studname = studname;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.classname = classname;
	}

	public int getStudid() {
		return studid;
	}
	public void setStudid(int studid) {
		this.studid = studid;
	}
	public String getStudname() {
		return studname;
	}
	public void setStudname(String studname) {
		this.studname = studname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	
}
