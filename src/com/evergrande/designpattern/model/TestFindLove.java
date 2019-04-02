package com.evergrande.designpattern.model;

import com.evergrande.designpattern.custom.MYMeipo;
import com.evergrande.designpattern.proxy.Person;
import com.evergrande.designpattern.proxy.ZhangSan;


public class TestFindLove {
	public static void main(String[] args) {
		try {
			Person obj = (Person) new MYMeipo().getInstance(new ZhangSan());
			
			System.out.println("代理后的类是：" + obj.getClass());
			obj.xiangQin();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
