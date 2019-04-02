package com.evergrande.designpattern.prototype.greatestsage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * �����ʥ
 * @author 100622161
 *
 */
public class TheGreatestSage extends Monkey implements Cloneable,Serializable{
	//�𹿰�
	private GoldRingedStaff staff;
	
	// ��ʯͷ����ĳ�����ʱ��
	public TheGreatestSage() {
		this.staff = new GoldRingedStaff();
		this.setBirthday(new Date());
		this.setHight(150);
		this.setWeight(30);
		System.out.println("----------------------------------------");
	}
	
	public void change() {
		TheGreatestSage copySage = (TheGreatestSage) clone();
		System.out.println("��ʥ���������ǣ�"+this.getBirthday().getTime());
		System.out.println("��ʥ��¡�����ǣ�"+copySage.getBirthday().getTime());
		System.out.println("��ʥ����ʹ�ʥ��¡�Ƿ�ͬһ����"+ (copySage == this));
		System.out.println("��ʥ����Ľ𹿰��ʹ�ʥ��¡�Ľ𹿰��Ƿ�ͬһ����"+ (copySage.getStaff() == this.getStaff()));
	}
	
	public GoldRingedStaff getStaff() {
		return staff;
	}


	public void setStaff(GoldRingedStaff staff) {
		this.staff = staff;
	}


	// ������
	public Object clone() {
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			//���л�
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(this);
			
			//�����л�
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
