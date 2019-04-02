package com.evergrande.designpattern.prototype.greatestsage;

import java.io.Serializable;

/**
 * �𹿰�
 * @author 100622161
 *
 */
public class GoldRingedStaff implements Serializable{
	// ����
	private float hight = 100;
	// ֱ��
	private float diameter = 10;
	
	/**
	 * �𹿰�����
	 */
	public void grow() {
		this.diameter *= 2;
		this.hight *= 2;
	}
	
	/**
	 * �𹿰���С
	 */
	public void shrink() {
		this.diameter /= 2;
		this.hight /= 2;
	}
}
