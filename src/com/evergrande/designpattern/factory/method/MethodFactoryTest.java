package com.evergrande.designpattern.factory.method;

import com.evergrande.designpattern.factory.Car;

public class MethodFactoryTest {
	public static void main(String[] args) {
		Factory factory = new AudiFactory();
		Car car = factory.getCar();
		System.out.println(car.getBrand());
		
		// ���⣺�û���ʼ��Ҫ���ģ������Ʒ��������
		factory = new BMWFactory();
	}
}
