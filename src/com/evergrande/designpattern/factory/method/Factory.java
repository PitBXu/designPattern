package com.evergrande.designpattern.factory.method;

import com.evergrande.designpattern.factory.Car;

//工厂接口定义了 所有工厂的执行标准
public interface Factory {
	// 符合汽车的标准
	// 尾气排放标准
	// 必须配备安全气囊
	// 轮胎耐磨
	Car getCar();
}
