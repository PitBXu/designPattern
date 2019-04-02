package com.evergrande.designpattern.proxy;

import java.io.FileOutputStream;

import sun.misc.ProxyGenerator;

public class TestFindLove {
	public static void main(String[] args) {
		try {
			Person obj = (Person) new Meipo().getInstance(new ZhangSan());
			
			System.out.println("代理后的类是：" + obj.getClass());
			
			/*
			 * 代理将person类给封装起来了，调用obj的xiangqin方法时自动执行代理
			 * 
			 */
			obj.xiangQin();	//随便调用obj的什么都会执行代理，而不是执行原来的xiangQin()方法
			
			//获取字节码内容
			byte [] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});//从内存中读的类
			FileOutputStream os = new FileOutputStream("D:\\test\\designPattern\\src\\com\\evergrande\\designpattern\\proxy\\$Proxy0.class");
			os.write(data);
			os.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
