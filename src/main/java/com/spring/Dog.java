package com.spring;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dogs_tbl")
public class Dog {

	@Id
	String name;
	String color;
	String breed;
	String url;
	Timestamp cdate;
	
	public Dog() {
	}

	public Dog(String name, String color, String breed, String url) {
		this.name = name;
		this.color = color;
		this.breed = breed;
		this.url = url;
	}

	public Timestamp getCdate() {
		return cdate;
	}

	public void setCdate(Timestamp cdate) {
		this.cdate = cdate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public String getBreed() {
		return breed;
	}

	public String getUrl() {
		return url;
	}

}
