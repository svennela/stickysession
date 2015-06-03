package com.pivotal.application;

import java.io.Serializable;

public class TestObject implements Serializable {
	private String name;
	private int age;
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
	@Override
	public String toString() {
		return "TestObject [name=" + name + ", age=" + age + "]";
	}
	public TestObject(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public TestObject() {}
}
