package com.evergrande.designpattern.proxy;

public class ZhangSan implements Person{

	
	String name = "����";
	String sex = "��";
	
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
		System.out.println("�ҽ�" + this.name + "��Ҫ�� ��Ů");
	}	
	
}
