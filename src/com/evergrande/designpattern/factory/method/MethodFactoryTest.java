package com.evergrande.designpattern.factory.method;

import com.evergrande.designpattern.factory.Car;

public class MethodFactoryTest {
	public static void main(String[] args) {
		Factory factory = new AudiFactory();
		Car car = factory.getCar();
		System.out.println(car.getBrand());
		
		// 问题：用户开始需要关心，这个产品的生产商
		factory = new BMWFactory();
	}
}
