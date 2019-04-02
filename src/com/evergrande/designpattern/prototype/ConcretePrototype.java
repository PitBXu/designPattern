package com.evergrande.designpattern.prototype;

import java.util.ArrayList;

public class ConcretePrototype implements Cloneable{
	
	public ArrayList<String> list = new ArrayList<>();
	
	private int age;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	protected Object clone() throws CloneNotSupportedException {
		
		// ���
		ConcretePrototype p = null;
		try {
			p = (ConcretePrototype) super.clone();
			p.list = (ArrayList<String>)list.clone();
			
			// ��¡�ǻ����ֽ����
			// 
		}catch(Exception e) {
			
		}
		
		return p;
	}
	
}
