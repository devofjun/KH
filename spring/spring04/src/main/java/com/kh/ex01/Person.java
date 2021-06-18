package com.kh.ex01;

import java.util.ArrayList;

public class Person {
	private String name; // 이름
	private int age; // 나이
	private ArrayList<String> hobbies; // 취미
	private double height; // 키
	private double weight; // 몸무게

	// 기본 생성자 없음

	// 필드 생성자(name, age, hobbies)
	public Person(String name, int age, ArrayList<String> hobbies) {
		super();
		this.name = name;
		this.age = age;
		this.hobbies = hobbies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weigth) {
		this.weight = weigth;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", hobbies=" + hobbies + ", height=" + height + ", weigth="
				+ weight + "]";
	}

}
