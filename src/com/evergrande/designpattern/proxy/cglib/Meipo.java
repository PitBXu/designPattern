package com.evergrande.designpattern.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Meipo implements MethodInterceptor{
	
	public Object getInstance(Class clz) throws Exception{
		// ͨ��������� ʵ��
		Enhancer enhancer = new Enhancer();
		// ���ø���
		enhancer.setSuperclass(clz);
		
		//���ûص����ص������ intercept����
		enhancer.setCallback(this);
		// 1. ����Դ����
		// 2.����� .class�ļ�
		// 3.���ص�JVM �У����ر��������
		return enhancer.create();
	}

	// ͬ���������ֽ�������һ����
	// ������Ҫ�ӿڣ�����ʹ�� API ���û���˵���޸�֪��
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("-----------������-------------------");
		System.out.println("��ʼ���к�ѡ......");
		
		// ������� invoke ������������ѭ��
		Object res = proxy.invokeSuper(obj, args);
		
		//this.target.xiangQin();
		System.out.println("������ʵĻ��ͽ��");
		return res;
	}
	
}
