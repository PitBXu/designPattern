package com.evergrande.designpattern.prototype.greatestsage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 齐天大圣
 * @author 100622161
 *
 */
public class TheGreatestSage extends Monkey implements Cloneable,Serializable{
	//金箍棒
	private GoldRingedStaff staff;
	
	// 从石头缝里蹦出来的时候
	public TheGreatestSage() {
		this.staff = new GoldRingedStaff();
		this.setBirthday(new Date());
		this.setHight(150);
		this.setWeight(30);
		System.out.println("----------------------------------------");
	}
	
	public void change() {
		TheGreatestSage copySage = (TheGreatestSage) clone();
		System.out.println("大圣本尊生日是："+this.getBirthday().getTime());
		System.out.println("大圣克隆生日是："+copySage.getBirthday().getTime());
		System.out.println("大圣本尊和大圣克隆是否同一对象？"+ (copySage == this));
		System.out.println("大圣本尊的金箍棒和大圣克隆的金箍棒是否同一对象？"+ (copySage.getStaff() == this.getStaff()));
	}
	
	public GoldRingedStaff getStaff() {
		return staff;
	}


	public void setStaff(GoldRingedStaff staff) {
		this.staff = staff;
	}


	// 分身技能
	public Object clone() {
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			//序列化
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(this);
			
			//反序列化
			bis = new ByteArrayInputStream(bos.toByteArray());
			ois = new ObjectInputStream(bis);
			TheGreatestSage copy = (TheGreatestSage) ois.readObject();
			copy.setBirthday(new Date());
			
			return copy;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				bos.close();
				oos.close();
				bis.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	
	
}
