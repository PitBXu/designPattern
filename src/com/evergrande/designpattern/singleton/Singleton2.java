package com.evergrande.designpattern.singleton;

public class Singleton2 {
	//����ʽ����̬����飬����
	private static Singleton2 instance;

    static {
        instance = new Singleton2();
    }

    private Singleton2() {}

    public static Singleton2 getInstance() {
        return instance;
    }
    /**
     *	 ���ַ�ʽ�� 1 ��ʵ���ƣ�ֻ��������ʵ�����Ĺ��̷����˾�̬������У�Ҳ������װ�ص�ʱ�򣬾�ִ�о�̬������еĴ��룬��ʼ�����ʵ������ȱ���������һ���ġ�
     */
}
