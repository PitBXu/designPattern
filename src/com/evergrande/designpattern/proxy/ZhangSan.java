package com.evergrande.designpattern.proxy;

public class ZhangSan implements Person{

	
	String name = "张三";
	String sex = "男";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void xiangQin() {
		System.out.println("我叫" + this.name + "我要找 美女");
	}	
	
}
