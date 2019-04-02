package com.evergrande.designpattern.factory;

public class SimpleFactoryTest {
	public static void main(String[] args) {
		//用户只关心车，不关心车怎么生产的
		Car car = new SimpleCarFactory().getCar("BMW");
		System.out.println(car.getBrand());
	}
}
