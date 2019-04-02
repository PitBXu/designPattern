package com.evergrande.designpattern.custom;

import java.lang.reflect.Method;

import com.evergrande.designpattern.proxy.Person;

public class MYMeipo implements MYInvocationHandler{

	private Person target;
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("啥也没干");
		target.xiangQin();
		return null;
	}
	
	public Object getInstance(Person target) throws Exception{
		this.target = target;
		//反射机制获取类
		Class clazz = target.getClass();
		
		return MYProxy.newProxyInstance(new MYClassLoader(), clazz.getInterfaces(), this);
	}

}
