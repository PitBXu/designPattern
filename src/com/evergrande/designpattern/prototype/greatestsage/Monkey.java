package com.evergrande.designpattern.prototype.greatestsage;

import java.util.Date;

/**
 *  ������
 * @author 100622161
 */
public class Monkey {
	//���
	protected int hight;
	//����
	protected int weight;
	//����
	protected Date birthday; // �ǻ�������
	public int getHight() {
		return hight;
	}
	public void setHight(int hight) {
		this.hight = hight;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
