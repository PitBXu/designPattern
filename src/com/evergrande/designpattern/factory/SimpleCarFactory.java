package com.evergrande.designpattern.factory;

public class SimpleCarFactory {
	// 实现 统一化，专业化管理
	// 如果没有工厂模式 - > 小作坊，三无产品
	public Car getCar(String name) {
		if ("BMW".equals(name.toUpperCase())) {
			return new BMW();
		}else if("AUDI".equals(name.toUpperCase())) {
			return new Audi();
		}else {
			return null;
		}
	}
}
