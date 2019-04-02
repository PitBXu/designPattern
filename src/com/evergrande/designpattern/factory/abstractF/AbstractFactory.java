package com.evergrande.designpattern.factory.abstractF;

import com.evergrande.designpattern.factory.Car;

public abstract class AbstractFactory {
	// ����Ĺ���������ֱ���ã�ʹ��DefaultFactory
	protected abstract Car getCar();
	
	public Car getCar(String name) {
		if ("BMW".equals(name.toUpperCase())) {
			return new BMWFactory().getCar();
		}else if("AUDI".equals(name.toUpperCase())) {
			return new AudiFactory().getCar();
		}else {
			return null;
		}
	}
}
