package com.li.test.drools.dto;

/**
 * @author yuan.li
 *
 */
public class Politician {
	private String name;

	private boolean honest;

	public Politician() {

	}

	public Politician(String name, boolean honest) {
		super();
		this.name = name;
		this.honest = honest;
	}

	public boolean isHonest() {
		return honest;
	}

	public void setHonest(boolean honest) {
		this.honest = honest;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Politician [name=" + name + ", honest=" + honest + "]";
	}
}
