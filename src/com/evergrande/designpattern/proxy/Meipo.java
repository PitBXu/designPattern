package com.evergrande.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//ý�� ������
public class Meipo implements InvocationHandler{
	
	private Person target;
	
	public Object getInstance(Person target) throws Exception{
		this.target = target;
		//������ƻ�ȡ��
		Class clazz = target.getClass();
		
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), clazz.getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("-----------������-------------------");
		System.out.println(this.target.getName() + "���Ա��� " + this.target.getSex());
		System.out.println("��ʼ���к�ѡ......");
		//this.target.xiangQin();
		method.invoke(this.target, args);
		System.out.println("������ʵĻ��ͽ��");
		return null;
	}
	
}
