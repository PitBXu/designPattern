package com.evergrande.designpattern.factory.abstractF;

import com.evergrande.designpattern.factory.BMW;
import com.evergrande.designpattern.factory.Car;

public class BMWFactory extends AbstractFactory {

	@Override
	protected Car getCar() {
		// TODO Auto-generated method stub
		return new BMW();
	}

}
