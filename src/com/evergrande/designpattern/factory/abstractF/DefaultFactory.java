package com.evergrande.designpattern.factory.abstractF;

import com.evergrande.designpattern.factory.Car;

public class DefaultFactory extends AbstractFactory{

	private AudiFactory defaultFactory = new AudiFactory();
	
	@Override
	protected Car getCar() {
		// TODO Auto-generated method stub
		return defaultFactory.getCar();
	}

}
