package com.evergrande.designpattern.singleton;

public class Singleton1 {
	//����ʽ����̬����������
	private final static Singleton1 INSTANCE = new Singleton1();
	
	private Singleton1() {}
	
	public static Singleton1 getInstance() {
		return INSTANCE;
	}
	/**
	 * 	�ŵ㣺����д���Ƚϼ򵥣���������װ�ص�ʱ������ʵ�������������߳�ͬ�����⡣
	 *	ȱ�㣺����װ�ص�ʱ������ʵ������û�дﵽLazy Loading��Ч���������ʼ���մ�δʹ�ù����ʵ�����������ڴ���˷ѡ�
	 */
}
