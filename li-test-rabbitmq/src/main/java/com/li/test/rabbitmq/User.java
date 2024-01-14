package com.li.test.rabbitmq;

import java.io.Serializable;

/**
 * @author yuan.li
 * 
 */
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4902071117070787408L;

	private String name;
	private String addr;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", addr=" + addr + "]";
	}
}
