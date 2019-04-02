package com.evergrande.designpattern.prototype;

public class CloneTest {
	
	public static void main(String[] args) {
		
		ConcretePrototype cp = new ConcretePrototype();
		cp.setAge(18);
		cp.list.add("Corey");
		
		try {
			// ��¡�� ֱ�Ӹ�ֵ�����𣺿�¡�õ�������ȫ��������
			// ��¡���ƣ�ֱ�Ӹ����ֽ���
			ConcretePrototype copy = (ConcretePrototype)cp.clone();
			System.out.println(copy.getAge() + "," + cp.list.size());
			// ������ true����Ϊֻ�� ��ǳ������ ��ֱ�ӿ����ĵ�ַ���Ľ���ʹ��list.clone();
			System.out.println(copy.list == cp.list);
			copy.list.add("Ha");
			System.out.println(cp.list.size());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		/**
		 *  ԭ��ģʽ�� ��һ���ֳɵĶ���������������Ѿ������úõ�ֵ�� 
		 *  ������Ҫ�½�һ������ ����Ҫ���½��Ķ���ֵ�����Ҹ�ֵ������Ҫ��֮ǰһģһ��
		 */		
	}
}
