package com.spring;

public class Dog {

	String name;
	String color;
	String breed;
	String url;

	public Dog() {
	}

	public Dog(String name, String color, String breed, String url) {
		this.name = name;
		this.color = color;
		this.breed = breed;
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
