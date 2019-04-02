package com.evergrande.designpattern.singleton;

//懒汉式
//这种写法，既解决了安全问题，又解决了性能问题
//没有浪费一个字
public class Singleton0 {
	//1. 先声明一个静态内部类
	// private 私有的保证别人不能修改
	// static 保证全局唯一
	private static class LazyHolder{
		// final 为了防止内部误操作，cglib的代理模式以子类方式实现，可能会修改该值
		private static final Singleton0 INSTANCE = new Singleton0();
	}
	//2.将默认构造方法私有化
	private Singleton0() {}
	
	//3. 同样提供静态方法获取实例
	// final 确保别人不能覆盖
	public static final Singleton0 getInstance() {
		return LazyHolder.INSTANCE;
	}
}
