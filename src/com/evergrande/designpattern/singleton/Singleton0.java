package com.evergrande.designpattern.singleton;

//����ʽ
//����д�����Ƚ���˰�ȫ���⣬�ֽ������������
//û���˷�һ����
public class Singleton0 {
	//1. ������һ����̬�ڲ���
	// private ˽�еı�֤���˲����޸�
	// static ��֤ȫ��Ψһ
	private static class LazyHolder{
		// final Ϊ�˷�ֹ�ڲ��������cglib�Ĵ���ģʽ�����෽ʽʵ�֣����ܻ��޸ĸ�ֵ
		private static final Singleton0 INSTANCE = new Singleton0();
	}
	//2.��Ĭ�Ϲ��췽��˽�л�
	private Singleton0() {}
	
	//3. ͬ���ṩ��̬������ȡʵ��
	// final ȷ�����˲��ܸ���
	public static final Singleton0 getInstance() {
		return LazyHolder.INSTANCE;
	}
}
