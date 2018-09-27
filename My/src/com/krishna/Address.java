package com.krishna;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	// instance veriable
	@Column(name = "FATHER")
	private String father;
	@Column(name = "VILLAGE")
	private String village;
	@Column(name = "DISTTRICT")
	private String disttrict;
	@Column(name = "STATE")
	private String state;

	// getter and setter
	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getDisttrict() {
		return disttrict;
	}

	public void setDisttrict(String disttrict) {
		this.disttrict = disttrict;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
