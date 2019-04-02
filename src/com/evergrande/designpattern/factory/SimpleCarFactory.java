package com.evergrande.designpattern.factory;

public class SimpleCarFactory {
	// ʵ�� ͳһ����רҵ������
	// ���û�й���ģʽ - > С���������޲�Ʒ
	public Car getCar(String name) {
		if ("BMW".equals(name.toUpperCase())) {
			return new BMW();
		}else if("AUDI".equals(name.toUpperCase())) {
			return new Audi();
		}else {
			return null;
		}
	}
}
