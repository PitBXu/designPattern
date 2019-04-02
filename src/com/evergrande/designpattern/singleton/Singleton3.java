package com.evergrande.designpattern.singleton;

public class Singleton3 {
	// ����ʽ ���̲߳���ȫ��������
	private static Singleton3 singleton;

    private Singleton3() {}

    public static Singleton3 getInstance() {
        if (singleton == null) {
            singleton = new Singleton3();
        }
        return singleton;
    }
/**
     *     ����д������Lazy Loading��Ч��������ֻ���ڵ��߳���ʹ�á�
     *     ����ڶ��߳��£�һ���߳̽�����if (singleton == null)�ж����飬��δ���ü�����ִ�У�
     *     ��һ���߳�Ҳͨ��������ж���䣬��ʱ���������ʵ���������ڶ��̻߳����²���ʹ�����ַ�ʽ��
  */
}
