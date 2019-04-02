package com.evergrande.designpattern.prototype.greatestsage;

import java.util.Date;

/**
 *  猴子类
 * @author 100622161
 */
public class Monkey {
	//身高
	protected int hight;
	//体重
	protected int weight;
	//生日
	protected Date birthday; // 非基本类型
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
