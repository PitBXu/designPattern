package com.evergrande.designpattern.factory.method;

import com.evergrande.designpattern.factory.Audi;
import com.evergrande.designpattern.factory.Car;

public class AudiFactory implements Factory {

	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return new Audi();
	}

}
