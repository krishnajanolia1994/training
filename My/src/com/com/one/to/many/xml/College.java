package com.one.to.many.xml;

import java.util.ArrayList;
import java.util.List;

public class College {
	private int id;
	private String name;
	private List<Student> studends = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudends() {
		return studends;
	}

	public void setStudends(List<Student> studends) {
		this.studends = studends;
	}

}
