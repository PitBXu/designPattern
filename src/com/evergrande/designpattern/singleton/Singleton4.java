package com.evergrande.designpattern.singleton;

public class Singleton4 {
	// ����ʽ���̰߳�ȫ�����Ƽ���
	private static Singleton4 singleton;

    private Singleton4() {}

    public static synchronized Singleton4 getInstance() {
        if (singleton == null) {
            singleton = new Singleton4();
        }
        return singleton;
    }
    
/**
     * ����̲߳���ȫ���⣬�����߳�ͬ�������ǾͶ�getInstance()�����������߳�ͬ����
     * ȱ�㣺Ч��̫���ˣ�ÿ���߳����������ʵ��ʱ��ִ��getInstance()������Ҫ����ͬ����
     * ����ʵ�������ִֻ��һ��ʵ��������͹��ˣ���������ø���ʵ����ֱ��return�����ˡ���������ͬ��Ч��̫��Ҫ�Ľ���
 */
}
