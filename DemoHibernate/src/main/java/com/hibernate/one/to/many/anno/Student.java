package com.hibernate.one.to.many.anno;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@ManyToOne
	private Collage college;

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

	public Collage getCollage() {
		return college;
	}

	public void setCollage(Collage collage) {
		this.college = collage;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", collage=" + college + "]";
	}

}
