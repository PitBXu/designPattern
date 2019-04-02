package com.evergrande.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//媒婆 代理类
public class Meipo implements InvocationHandler{
	
	private Person target;
	
	public Object getInstance(Person target) throws Exception{
		this.target = target;
		//反射机制获取类
		Class clazz = target.getClass();
		
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), clazz.getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("-----------代理类-------------------");
		System.out.println(this.target.getName() + "的性别是 " + this.target.getSex());
		System.out.println("开始进行海选......");
		//this.target.xiangQin();
		method.invoke(this.target, args);
		System.out.println("如果合适的话就结婚");
		return null;
	}
	
}
