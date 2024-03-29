package com.li.test.drools.dto;

import java.io.Serializable;

/**
 * @author yuan.li
 *
 */
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer age;

	private String name;

	private String desc;

	public Person() {
	}

	public Person(Integer age, String name, String desc) {
		this.age = age;
		this.name = name;
		this.desc = desc;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", desc=" + desc + "]";
	}
}
