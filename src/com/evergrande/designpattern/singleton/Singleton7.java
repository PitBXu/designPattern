package com.evergrande.designpattern.singleton;

public class Singleton7 {
	//����ʽ��ͬ Singleton0
	private Singleton7() {}

    private static class SingletonInstance {
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance() {
        return SingletonInstance.INSTANCE;
    }

    
/**
 * ���ַ�ʽ������ʽ��ʽ���õĻ������ƣ������в�ͬ�����߶��ǲ�������װ�صĻ�������֤��ʼ��ʵ��ʱֻ��һ���̡߳�
 * ��ͬ�ĵط��ڶ���ʽ��ʽ��ֻҪSingleton�౻װ�ؾͻ�ʵ������û��Lazy-Loading�����ã�
 * ����̬�ڲ��෽ʽ��Singleton�౻װ��ʱ����������ʵ��������������Ҫʵ����ʱ������getInstance������
 * �Ż�װ��SingletonInstance�࣬�Ӷ����Singleton��ʵ������
 * ��ľ�̬����ֻ���ڵ�һ�μ������ʱ���ʼ�������������JVM�������Ǳ�֤���̵߳İ�ȫ�ԣ�������г�ʼ��ʱ������߳����޷�����ġ�
 * 
 * �ŵ㣺�������̲߳���ȫ���ӳټ��أ�Ч�ʸߡ�
 */
}
