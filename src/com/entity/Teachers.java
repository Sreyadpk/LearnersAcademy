package com.entity;

public class Teachers {
	  private int tid;
	  private String tname;
	  private int age;
	  private String gender;
	  private String email;
	  private String subject;
	  
	  
	public Teachers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teachers(int tid, String tname, int age, String gender, String email, String subject) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.subject = subject;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	  
	  
}
