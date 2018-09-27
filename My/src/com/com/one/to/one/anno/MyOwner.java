package com.com.one.to.one.anno;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MY_OWNER")
public class MyOwner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "myOwner", cascade = CascadeType.ALL)
	private MyCountry myCountry;

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

	public MyCountry getMyCountry() {
		return myCountry;
	}

	public void setMyCountry(MyCountry myCountry) {
		this.myCountry = myCountry;
	}

}
