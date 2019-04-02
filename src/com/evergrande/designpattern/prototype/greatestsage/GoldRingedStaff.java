package com.evergrande.designpattern.prototype.greatestsage;

import java.io.Serializable;

/**
 * 金箍棒
 * @author 100622161
 *
 */
public class GoldRingedStaff implements Serializable{
	// 长度
	private float hight = 100;
	// 直径
	private float diameter = 10;
	
	/**
	 * 金箍棒长大
	 */
	public void grow() {
		this.diameter *= 2;
		this.hight *= 2;
	}
	
	/**
	 * 金箍棒缩小
	 */
	public void shrink() {
		this.diameter /= 2;
		this.hight /= 2;
	}
}
