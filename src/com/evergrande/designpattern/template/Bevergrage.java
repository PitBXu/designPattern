package com.evergrande.designpattern.template;

public abstract class Bevergrage {
	
	//���ܱ���д
	public final void create() {
		// 1.��ˮ�տ�
		boilWater();
		// �ѱ���׼����
		putInCup();
		// ��ˮ����
		brew();
		// ��Ӹ���
		addCoundiments();
	}

	private void brew() {
		System.out.println("׼���ñ���");
	}

	public abstract void putInCup();
	
	public abstract void addCoundiments();

	private void boilWater() {
		System.out.println("�տ�ˮ���տ���100���϶�");
	}
}
