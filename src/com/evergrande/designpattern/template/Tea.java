package com.evergrande.designpattern.template;

public class Tea extends Bevergrage{

	// 放原料
	public void putInCup() {
		System.out.println("添加龙井茶");
	}

	// 添加蜂蜜
	public void addCoundiments() {
		System.out.println("添加蜂蜜");
	}

}
