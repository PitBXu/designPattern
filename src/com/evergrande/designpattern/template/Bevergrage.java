package com.evergrande.designpattern.template;

public abstract class Bevergrage {
	
	//不能被重写
	public final void create() {
		// 1.把水烧开
		boilWater();
		// 把杯子准备好
		putInCup();
		// 用水冲泡
		brew();
		// 添加辅料
		addCoundiments();
	}

	private void brew() {
		System.out.println("准备好杯子");
	}

	public abstract void putInCup();
	
	public abstract void addCoundiments();

	private void boilWater() {
		System.out.println("烧开水，烧开到100摄氏度");
	}
}
