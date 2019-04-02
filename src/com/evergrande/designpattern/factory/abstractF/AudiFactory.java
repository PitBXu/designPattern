package com.evergrande.designpattern.factory.abstractF;

import com.evergrande.designpattern.factory.Audi;
import com.evergrande.designpattern.factory.Car;

public class AudiFactory extends AbstractFactory {

	@Override
	protected Car getCar() {
		// TODO Auto-generated method stub
		return new Audi();
	}

}
