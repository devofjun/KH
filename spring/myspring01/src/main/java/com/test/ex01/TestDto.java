package com.test.ex01;

import java.util.Arrays;

public class TestDto {
	private String t_name;
	private int t_age;
	private double t_height;
	private String[] hobbies;
	
	public TestDto() {
		super();
	}
	public TestDto(String t_name, int t_age, double t_height) {
		super();
		this.t_name = t_name;
		this.t_age = t_age;
		this.t_height = t_height;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public int getT_age() {
		return t_age;
	}
	public void setT_age(int t_age) {
		this.t_age = t_age;
	}
	public double getT_height() {
		return t_height;
	}
	public void setT_height(double t_height) {
		this.t_height = t_height;
	}
	
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	@Override
	public String toString() {
		return "TestDto [t_name=" + t_name + ", t_age=" + t_age + ", t_height=" + t_height + ", hobbies="
				+ Arrays.toString(hobbies) + "]";
	}
	
	
}
