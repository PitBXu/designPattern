package com.evergrande.designpattern.factory.abstractF;

public class AbstractFactoryTest {
	public static void main(String[] args) {
		DefaultFactory def = new DefaultFactory();
		System.out.println(def.getCar("bmw").getBrand());
	}
}
