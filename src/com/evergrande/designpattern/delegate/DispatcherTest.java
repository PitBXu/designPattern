package com.evergrande.designpattern.delegate;

public class DispatcherTest {
	public static void main(String[] args) {
		
		Dispatcher dispatcher = new Dispatcher(new ExecutorA());
		//��������������Ŀ�����ڸɻʵ������ͨԱ���ڸɻ�
		dispatcher.doing();
	}
}
