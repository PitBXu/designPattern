package com.evergrande.designpattern.custom;

import java.lang.reflect.Method;

import com.evergrande.designpattern.proxy.Person;

public class MYMeipo implements MYInvocationHandler{

	private Person target;
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("ɶҲû��");
		target.xiangQin();
		return null;
	}
	
	public Object getInstance(Person target) throws Exception{
		this.target = target;
		//������ƻ�ȡ��
		Class clazz = target.getClass();
		
		return MYProxy.newProxyInstance(new MYClassLoader(), clazz.getInterfaces(), this);
	}

}
