package com.evergrande.designpattern.factory.method;

import com.evergrande.designpattern.factory.BMW;
import com.evergrande.designpattern.factory.Car;

public class BMWFactory implements Factory {

	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return new BMW();
	}

}
