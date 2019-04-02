package com.evergrande.designpattern.template;

public class Coffee extends Bevergrage {

	//原材料放入杯中
	public void putInCup() {
		System.out.println("将咖啡放入杯中");
	}

	//放辅料
	public void addCoundiments() {
		System.out.println("添加牛奶和糖");
	}

}
