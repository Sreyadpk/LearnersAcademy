package com.entity;

public class Classes {
 private int classid;
 private String classname;
 private int totstrength;
 
 
public Classes() {
	super();
}


public Classes(int classid, String classname, int totstrength) {
	super();
	this.classid = classid;
	this.classname = classname;
	this.totstrength = totstrength;
}


public int getClassid() {
	return classid;
}
public void setClassid(int classid) {
	this.classid = classid;
}
public String getClassname() {
	return classname;
}
public void setClassname(String classname) {
	this.classname = classname;
}
public int getTotstrength() {
	return totstrength;
}
public void setTotstrength(int totstrength) {
	this.totstrength = totstrength;
}
 
 
 
}
