package com.evergrande.designpattern.factory;

public class SimpleFactoryTest {
	public static void main(String[] args) {
		//�û�ֻ���ĳ��������ĳ���ô������
		Car car = new SimpleCarFactory().getCar("BMW");
		System.out.println(car.getBrand());
	}
}
