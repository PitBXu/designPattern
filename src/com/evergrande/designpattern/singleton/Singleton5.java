package com.evergrande.designpattern.singleton;

public class Singleton5 {
	// ����ʽ���߳̿��ư�ȫ��������
	private static Singleton5 singleton;

    private Singleton5() {}

    public static Singleton5 getInstance() {
        if (singleton == null) {
            synchronized (Singleton5.class) {
                singleton = new Singleton5();
            }
        }
        return singleton;
    }
/**
 * ���ڵ�����ʵ�ַ�ʽͬ��Ч��̫�ͣ���������ͬ����������Ϊͬ������ʵ�����ĵĴ���顣
 * ��������ͬ�����������߳�ͬ�������á�����3��ʵ�ַ�ʽ����������һ�£�
 * ����һ���߳̽�����if (singleton == null)�ж����飬
 * ��δ���ü�����ִ�У���һ���߳�Ҳͨ��������ж���䣬��ʱ���������ʵ����
 */
}
